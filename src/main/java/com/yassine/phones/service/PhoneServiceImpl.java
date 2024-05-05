package com.yassine.phones.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;
import com.yassine.phones.repos.PhonesRepostory;
import com.yassine.phones.repos.TypeRepository;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhonesRepostory smartPhoneRepository;
    @Autowired
    private TypeRepository typeRepository;


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
    public SmartPhone getSmartPhone(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<SmartPhone> getAllSmartPhones() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public List<SmartPhone> findByMarque(String marque) {
        return smartPhoneRepository.findByMarque(marque);
    }

    @Override
    public List<SmartPhone> findByMarquePrix(String marque, Double prix) {
        return smartPhoneRepository.findByMarquePrix(marque, prix);
    }

    @Override
    public List<SmartPhone> findByType(Type type) {
        return smartPhoneRepository.findByType(type);
    }

    @Override
    public List<SmartPhone> findByTypeId(Long id) {
        return smartPhoneRepository.findByType_IdType(id);
    }

    @Override
    public List<SmartPhone> findByOrderByMarqueAsc() {
        return smartPhoneRepository.findByOrderByMarqueAsc();
    }

    @Override
    public List<SmartPhone> findByPhoneContains(String marque) {
        return smartPhoneRepository.findByMarqueContains(marque);
    }

    @Override
    public List<SmartPhone> trierPhonesNomsPrix() {
        return smartPhoneRepository.trierPhonesNomsPrix();
    }

    @Override
    public Page<SmartPhone> getAllPhonesParPage(int page, int size) {
        return smartPhoneRepository.findAll(PageRequest.of(page, size));
    }
    
    @Override
    public List<Type> getAllTypes() {
    return typeRepository.findAll();
    }
    
}
