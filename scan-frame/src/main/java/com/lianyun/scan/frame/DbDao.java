package com.lianyun.scan.frame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DbDao<K, V> extends JpaRepository<V, K>, JpaSpecificationExecutor<V> {

}
