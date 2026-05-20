package com.karthi.springjpa730.repo;

import com.karthi.springjpa730.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo  extends JpaRepository<Store,Integer> {

}
