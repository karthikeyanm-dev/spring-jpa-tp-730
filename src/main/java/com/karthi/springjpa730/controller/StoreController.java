package com.karthi.springjpa730.controller;

import com.karthi.springjpa730.model.Store;
import com.karthi.springjpa730.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreService  storeService;

    @PostMapping("/register")
    public ResponseEntity<Store> registerStore(@RequestBody Store store){
        Store savedData =  storeService.saveStore(store);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @GetMapping("/stores")
    public ResponseEntity<?> allStores(){
        List<Store> allStores =  storeService.findAllStore();
        HashMap<String,Object> storeMap = new HashMap<>();

        if(allStores.size() > 0){
            storeMap.put("totalStore" , allStores.size());
            storeMap.put("stores",allStores);
            return new ResponseEntity<>(storeMap,HttpStatus.OK); // Return all Datas
        }
        storeMap.put("totalStores",0);
        return new ResponseEntity<>(storeMap, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<?> findStore(@PathVariable Integer id){
        Store fetchedData = storeService.findStore(id);

        HashMap<String,Object> map =  new HashMap<>();

        if(fetchedData == null){
            map.put("message", "Store not found for the given ID : " +id);
            return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        map.put("data",fetchedData);
        return  new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping("/stores/{id}")
    public ResponseEntity<?> updateStore(@RequestBody Store updateStoreData, @PathVariable Integer id){
        Store updatedStore = storeService.updateStore(updateStoreData, id);
        if(updatedStore != null){
            return new ResponseEntity<>(updatedStore, HttpStatus.OK) ;
        }
//        Create map and you can send in entity
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/stores/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Integer id){
        HashMap<String,Object> map = new HashMap<>();
        map.put("message", "Store not found for the given ID : " +id);
        return storeService.deleteStore(id) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new  ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }


    @GetMapping("/stores/search")
    public ResponseEntity<?> findByKeyword(@RequestParam String keyword){
        List<Store> allStores = storeService.findAllStoreByKeyword(keyword);

        HashMap<String,Object> storeMap = new HashMap<>();

        if(allStores.size() > 0){
            storeMap.put("totalStore" , allStores.size());
            storeMap.put("stores",allStores);
            return new ResponseEntity<>(storeMap,HttpStatus.OK); // Return all relevant Data
        }
        storeMap.put("totalStores",0);
        return new ResponseEntity<>(storeMap, HttpStatus.NOT_FOUND);
    }

}
