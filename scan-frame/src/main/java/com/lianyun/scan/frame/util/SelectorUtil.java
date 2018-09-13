package com.lianyun.scan.frame.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.lianyun.scan.frame.model.Children;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.frame.model.Selector;

public class SelectorUtil {

	public static List<Selector> toSelector(List<? extends Name> names) {

		List<Selector> selectors = new ArrayList<>();
		for (Name name : names) {
			selectors.add(toSelector(name));
		}
		return selectors;
	}

	public static Selector toSelector(Name name) {

		Selector selector = new Selector();
		selector.setName(name.getName());
		selector.setId(name.getId());

		try {
			Class<? extends Name> cls = name.getClass();

			List<Field> fields = ClassUtil.getAllFields(cls);
			for (Field field : fields) {
				Children c = field.getAnnotation(Children.class);
				if (c != null) {
					field.setAccessible(true);
					List<Selector> children = toSelector((List<? extends Name>) field.get(name));
					selector.setChildren(children);
					continue;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return selector;
	}

}
