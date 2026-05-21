package com.karthi.springjpa730.controller;

import com.karthi.springjpa730.model.Store;
import com.karthi.springjpa730.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreService  storeService;

    @PostMapping("/register")
    public Store registerStore(@RequestBody Store store){
        return storeService.saveStore(store);
    }

    @GetMapping("/stores")
    public List<Store> allStores(){
        return storeService.findAllStore();
    }

    @GetMapping("/stores/{id}")
    public Store findStore(@PathVariable Integer id){
        return storeService.findStore(id);
    }

    @PutMapping("/stores/{id}")
    public Store updateStore(@RequestBody Store updateStoreData, @PathVariable Integer id){
        Store updatedStore = storeService.updateStore(updateStoreData, id);
        if(updatedStore != null){
            return updatedStore;
        }
        return new Store(-1);
    }


    @DeleteMapping("/stores/{id}")
    public String deleteStore(@PathVariable Integer id){
        return storeService.deleteStore(id) ? "Store Deleted" : "Store Not Deleted and Store is Not available ";
    }


    @GetMapping("/stores/search")
    public List<Store> findByKeyword(@RequestParam String keyword){
        return storeService.findAllStoreByKeyword(keyword);
    }






}
