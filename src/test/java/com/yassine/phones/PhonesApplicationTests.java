package com.yassine.phones;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;
import com.yassine.phones.repos.PhonesRepostory;
import com.yassine.phones.service.PhoneService;

@SpringBootTest
class PhonesApplicationTests {

	@Autowired
	private PhonesRepostory phoneRepository;

	@Autowired
	private PhoneService phoneService;

	@Test
	public void testFindByType() {
		Type type = new Type();
		type.setIdType(1L);
		List<SmartPhone> phones = phoneRepository.findByType(type);
		for (SmartPhone p : phones) {
			System.out.println(p);
		}
	}

	@Test
	public void findByTypeId() {
		List<SmartPhone> phones = phoneRepository.findByType_IdType(1L);
		for (SmartPhone p : phones) {
			System.out.println(p);
		}
	}

	@Test
	public void testCreateSmartPhone() {
		SmartPhone smartPhone = new SmartPhone("Samsung", "Noir", 999.99, 8, 256, new Date());
		phoneRepository.save(smartPhone);
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
	public void testListerTousSmartPhones() {
		List<SmartPhone> smartPhones = phoneRepository.findAll();
		for (SmartPhone smartPhone : smartPhones) {
			System.out.println(smartPhone);
		}
	}

	@Test
	public void testFindByMarquePrix() {
		List<SmartPhone> phones = phoneRepository.findByMarquePrix("iPhone 13", 1299.99);
		for (SmartPhone p : phones) {
			System.out.println(p.toString());
		}
	}

	@Test
	public void testFindByOrderByMarqueAsc() {
		List<SmartPhone> phones = phoneRepository.findByOrderByMarqueAsc();
		for (SmartPhone p : phones) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierPhonesNomsPrix() {
		List<SmartPhone> phones = phoneRepository.trierPhonesNomsPrix();
		for (SmartPhone p : phones) {
			System.out.println(p);
		}
	}
}
