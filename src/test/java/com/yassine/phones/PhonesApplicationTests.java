package com.yassine.phones;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.repos.PhonesRepostory;
import com.yassine.phones.service.PhoneService;

@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    private PhonesRepostory phoneRepository;

    @Autowired
    private PhoneService phoneService;

    @Test
    public void testCreateSmartPhone() {
        SmartPhone smartPhone = new SmartPhone("Samsung", "Noir", 999.99, 8, 256, new Date());
        phoneRepository.save(smartPhone);
    }

    @Test
    public void testFindSmartPhone() {
        SmartPhone smartPhone = phoneRepository.findById(1L).orElse(null);
        System.out.println(smartPhone);
    }

    @Test
    public void testUpdateSmartPhone() {
        SmartPhone smartPhone = phoneRepository.findById(1L).orElse(null);
        if (smartPhone != null) {
            smartPhone.setPrix(1000.0);
            phoneRepository.save(smartPhone);
        }
    }

    @Test
    public void testFindByNomProduitContains() {
        Page<SmartPhone> prods = phoneService.getAllPhonesParPage(0, 2);
        System.out.println(prods.getSize());
        System.out.println(prods.getTotalElements());
        System.out.println(prods.getTotalPages());
        prods.getContent().forEach(p -> {
            System.out.println(p.toString());
        });
    }

    @Test
    public void testDeleteSmartPhone() {
        phoneRepository.deleteById(1L);
    }

    @Test
    public void testListerTousSmartPhones() {
        List<SmartPhone> smartPhones = phoneRepository.findAll();
        for (SmartPhone smartPhone : smartPhones) {
            System.out.println(smartPhone);
        }
    }
}
