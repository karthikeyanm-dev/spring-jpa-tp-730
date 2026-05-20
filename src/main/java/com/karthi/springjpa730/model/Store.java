package com.karthi.springjpa730.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int storeId;

    String storeName;
    String storeCategory;
    String storeAddress;
    String storePhone;
    String storeEmail;
}

