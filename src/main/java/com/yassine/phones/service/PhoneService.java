package com.yassine.phones.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;

public interface PhoneService {
    SmartPhone saveSmartPhone(SmartPhone smartPhone);
    SmartPhone updateSmartPhone(SmartPhone smartPhone);
    void deleteSmartPhone(SmartPhone smartPhone);
    void deleteSmartPhoneById(Long id);
    SmartPhone getSmartPhone(Long id);
    Page<SmartPhone> getAllPhonesParPage(int page, int size);
    List<SmartPhone> getAllSmartPhones();
    List<SmartPhone> findByMarque(String marque);
    List<SmartPhone> findByPhoneContains(String marque);
    List<SmartPhone> findByMarquePrix(String marque, Double prix);
    List<SmartPhone> findByType(Type type);
    List<SmartPhone> findByTypeId(Long id);
    List<SmartPhone> findByOrderByMarqueAsc();
    List<SmartPhone> trierPhonesNomsPrix();
    List<Type> getAllTypes();

}
