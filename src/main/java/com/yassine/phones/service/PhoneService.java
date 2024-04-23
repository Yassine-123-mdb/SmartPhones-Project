package com.yassine.phones.service;
import java.util.List;


import org.springframework.data.domain.Page;

import com.yassine.phones.entities.SmartPhone;

public interface PhoneService {
    SmartPhone saveSmartPhone(SmartPhone smartPhone);
    SmartPhone updateSmartPhone(SmartPhone smartPhone);
    void deleteSmartPhone(SmartPhone smartPhone);
    void deleteSmartPhoneById(Long id);
    SmartPhone getSmartPhone(Long id);
    List<SmartPhone> getAllSmartPhones();
    Page<SmartPhone> getAllPhonesParPage(int page, int size);
}
