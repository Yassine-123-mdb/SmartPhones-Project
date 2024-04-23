package com.yassine.phones.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.repos.PhonesRepostory;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhonesRepostory smartPhoneRepository;

    @Override
    public SmartPhone saveSmartPhone(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public SmartPhone updateSmartPhone(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void deleteSmartPhone(SmartPhone smartPhone) {
        smartPhoneRepository.delete(smartPhone);
    }

    @Override
    public void deleteSmartPhoneById(Long id) {
        smartPhoneRepository.deleteById(id);
    }
    @Override
    public Page<SmartPhone> getAllPhonesParPage(int page, int size) {
    return smartPhoneRepository.findAll(PageRequest.of(page, size));
    }


    @Override
    public SmartPhone getSmartPhone(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<SmartPhone> getAllSmartPhones() {
        return smartPhoneRepository.findAll();
    }
}
