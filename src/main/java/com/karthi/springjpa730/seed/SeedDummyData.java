package com.karthi.springjpa730.seed;

import com.karthi.springjpa730.model.Store;
import com.karthi.springjpa730.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedDummyData implements CommandLineRunner {

    @Autowired
    StoreRepo storeRepo;

    @Override
    public void run(String... args) throws Exception {
        long storeCount = storeRepo.count();
        System.out.println("Store count: " + storeCount);


        List<Store> stores = new ArrayList<>(
                List.of(
                        new Store(0, "Zudio", "Clothing", "Phoenix MarketCity, Chennai", "9876543210", "support@zudio.com"),
                        new Store(0, "Reliance Trends", "Clothing", "Express Avenue Mall, Chennai", "9840011122", "care@trends.in"),
                        new Store(0, "Lifestyle", "Fashion", "VR Chennai Mall, Chennai", "9788899001", "help@lifestylestores.com"),
                        new Store(0, "Max Fashion", "Clothing", "Forum Vijaya Mall, Chennai", "9876501234", "contact@maxfashion.com"),
                        new Store(0, "Pantaloons", "Fashion", "Ampa Skywalk, Chennai", "9090909090", "support@pantaloons.com"),

                        new Store(0, "Poorvika Mobiles", "Electronics", "T Nagar, Chennai", "9500012345", "sales@poorvika.com"),
                        new Store(0, "Sangeetha Mobiles", "Electronics", "Velachery, Chennai", "9444456789", "support@sangeethamobiles.com"),
                        new Store(0, "Croma", "Electronics", "Anna Nagar, Chennai", "9888877766", "help@croma.com"),
                        new Store(0, "Viveks", "Electronics", "Tambaram, Chennai", "9797979797", "care@viveks.com"),
                        new Store(0, "iPlanet", "Electronics", "OMR, Chennai", "9123456780", "info@iplanet.in"),

                        new Store(0, "Saravana Stores", "Retail", "Ranganathan Street, Chennai", "9000011111", "contact@saravanastores.com"),
                        new Store(0, "D Mart", "Supermarket", "Porur, Chennai", "9333344444", "help@dmart.in"),
                        new Store(0, "More Supermarket", "Supermarket", "Chromepet, Chennai", "9555566666", "support@more.com"),
                        new Store(0, "Nilgiris", "Grocery", "Adyar, Chennai", "9888800001", "care@nilgiris1905.com"),
                        new Store(0, "Heritage Fresh", "Grocery", "Medavakkam, Chennai", "9677012345", "hello@heritagefresh.com"),

                        new Store(0, "Apollo Pharmacy", "Pharmacy", "Ashok Nagar, Chennai", "9000099999", "support@apollopharmacy.in"),
                        new Store(0, "MedPlus", "Pharmacy", "KK Nagar, Chennai", "9871234567", "care@medplusindia.com"),
                        new Store(0, "Netmeds Store", "Pharmacy", "Guindy, Chennai", "9345678910", "help@netmeds.com"),

                        new Store(0, "Cafe Coffee Day", "Cafe", "Besant Nagar, Chennai", "9001231234", "support@ccd.com"),
                        new Store(0, "Starbucks", "Cafe", "Nungambakkam, Chennai", "9888001122", "customerservice@starbucks.in"),
                        new Store(0, "A2B", "Restaurant", "Vadapalani, Chennai", "9555512345", "support@aabsweets.com"),
                        new Store(0, "Domino's Pizza", "Restaurant", "Perungudi, Chennai", "9600011111", "guestcaredominos@jublfood.com"),
                        new Store(0, "Burger King", "Restaurant", "Sholinganallur, Chennai", "9877777777", "support@burgerking.in"),

                        new Store(0, "Naturals Salon", "Beauty", "Velachery, Chennai", "9444401234", "care@naturals.in"),
                        new Store(0, "Green Trends", "Beauty", "Tambaram, Chennai", "9888123456", "support@greentrends.in"),
                        new Store(0, "Toni & Guy", "Beauty", "Anna Nagar, Chennai", "9004455667", "hello@toniandguy.in"),

                        new Store(0, "Decathlon", "Sports", "Perungudi, Chennai", "9789001122", "support@decathlon.com"),
                        new Store(0, "Puma Store", "Sports", "Phoenix Mall, Chennai", "9870011223", "care@puma.com"),
                        new Store(0, "Adidas Originals", "Sports", "Express Avenue, Chennai", "9098765432", "support@adidas.in"),

                        new Store(0, "Home Centre", "Furniture", "VR Mall, Chennai", "9555010101", "care@homecentre.in")
                )
        );

       if(storeCount == 0){
           System.out.println("No data's in DB  so started to seed data's");
           storeRepo.saveAll(stores);
           System.out.println("Data saved in DB");
           return;
       }

        System.out.println("Skipping seeding part.....");
    }
}
