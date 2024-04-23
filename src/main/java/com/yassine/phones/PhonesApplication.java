package com.yassine.phones;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.service.PhoneService;

@SpringBootApplication
public class PhonesApplication implements CommandLineRunner {

    @Autowired
    PhoneService phoneService;

    public static void main(String[] args) {
        SpringApplication.run(PhonesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        phoneService.saveSmartPhone(new SmartPhone("Samsung Galaxy", "Noir", 999.99, 8, 256, new Date()));
        phoneService.saveSmartPhone(new SmartPhone("iPhone 13","Argent", 1299.99,  8, 512, new Date()));
        phoneService.saveSmartPhone(new SmartPhone("OnePlus 9","Vert", 899.99, 8, 128, new Date()));
    }
}

