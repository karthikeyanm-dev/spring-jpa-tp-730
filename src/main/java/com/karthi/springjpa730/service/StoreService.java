package com.karthi.springjpa730.service;

import com.karthi.springjpa730.model.Store;
import com.karthi.springjpa730.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreRepo storeRepo;

    public Store saveStore(Store store){
        return storeRepo.save(store);
    }

    public Store findStore(Integer storeId){
        return  storeRepo.findById(storeId).orElse(null);
    }

    public List<Store> findAllStore(){
        return storeRepo.findAll();
    }

    public Store updateStore(Store store,Integer storeId){
        Store existingStore = findStore(storeId);
        if (existingStore != null){
            existingStore.setStoreName(store.getStoreName());
            existingStore.setStoreAddress(store.getStoreAddress());
            existingStore.setStoreCategory(store.getStoreCategory());
            existingStore.setStorePhone(store.getStorePhone());
            existingStore.setStoreEmail(store.getStoreEmail());
            return storeRepo.save(existingStore);
        }
        return null;
    }

    public  boolean deleteStore(Integer storeId){
        Store store = findStore(storeId);
        if (store!=null){
            storeRepo.deleteById(storeId);
            return true;
        }
        return false;
    }


    public List<Store> findAllStoreByKeyword(String keyword){
        return storeRepo.searchAllFields(keyword);
    }

}
