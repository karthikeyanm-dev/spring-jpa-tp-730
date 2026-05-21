package com.karthi.springjpa730.repo;

import com.karthi.springjpa730.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepo  extends JpaRepository<Store,Integer> {


    @Query("""
        SELECT s from Store s where 
        lower(s.storeName) like lower(concat('%', :keyword, '%')) or 
        lower(s.storeCategory) like lower(concat('%', :keyword, '%')) or 
        lower(s.storePhone) like lower(concat('%', :keyword, '%')) or
        lower(s.storeAddress) like lower(concat('%', :keyword, '%')) 
""")
    public List<Store> searchAllFields(@Param("keyword") String keyword);


    List<Store> findStoreByStoreIdGreaterThan(int storeIdIsGreaterThan);
}
