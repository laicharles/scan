package com.lianyun.scan.frame;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lianyun.scan.frame.model.Condition;
import com.lianyun.scan.frame.model.ConditionType;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.frame.util.ClassUtil;

public abstract class BaseDaoDbImpl<K, V> implements IDao<K, V> {

	@Autowired
	protected DbDao<K, V> dbDao;

	private Specification<V> toSpecification(PageCondition pageCondition) {

		Specification<V> specification = new Specification<V>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<V> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				try {

					List<Field> fields = ClassUtil.getAllFields(pageCondition.getClass());
					for (Field field : fields) {
						Condition condition = field.getAnnotation(Condition.class);

						if (condition != null) {

							field.setAccessible(true);

							Object v = field.get(pageCondition);

							if (v == null) {
								continue;
							}

							ConditionType type = condition.type();
							switch (type) {
							case EQUAL:
								list.add(cb.equal(root.get(condition.value()).as(field.getType()), v));
								break;
							case LIKE:
								String p = "%" + v + "%";
								list.add(cb.like(root.get(condition.value()).as(String.class), p));
								break;
							default:
								break;
							}

						}

					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

				Predicate[] p = new Predicate[list.size()];
				query.where(cb.and(list.toArray(p)));
				return query.getRestriction();
			}
		};

		return specification;

	}

	@Override
	public List<V> list(PageCondition pageCondition) {

		Specification<V> specification = toSpecification(pageCondition);
		Pageable pageable = PageRequest.of(pageCondition.getPage() - 1, pageCondition.getSize());

		List<V> list = dbDao.findAll(specification, pageable).getContent();
		return list;

	}

	@Override
	public long count(PageCondition pageCondition) {

		Specification<V> specification = toSpecification(pageCondition);
		return dbDao.count(specification);
	}

	@Override
	public V get(K k) {

		Optional<V> o = dbDao.findById(k);
		if (o.isPresent()) {
			return o.get();
		}
		return null;
		// return dbDao.getOne(k);
	}

	@Override
	public boolean add(V v) {
		dbDao.save(v);
		return true;
	}

	@Override
	public boolean delete(K k) {
		dbDao.deleteById(k);
		return true;
	}

	@Override
	public boolean edit(K k, V v) {
		//TODO 后续改
		dbDao.save(v);
		return true;
	}

	
	
}
