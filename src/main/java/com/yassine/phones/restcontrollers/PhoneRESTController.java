package com.yassine.phones.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.service.PhoneService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PhoneRESTController {
	@Autowired
	PhoneService phoneService;

	@RequestMapping(method = RequestMethod.GET)
	public List<SmartPhone> getAllPhones() {
		return phoneService.getAllSmartPhones();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SmartPhone getPhoneById(@PathVariable("id") Long id) {
		return phoneService.getSmartPhone(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public SmartPhone createPhone(@RequestBody SmartPhone phone) {
	return phoneService.saveSmartPhone(phone);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public SmartPhone updatePhone(@RequestBody SmartPhone phone) {
	return phoneService.updateSmartPhone(phone);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePhone(@PathVariable("id") Long id)
	{
		phoneService.deleteSmartPhoneById(id);
	}
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<SmartPhone> getPhonesByCatId(@PathVariable("idCat") Long idCat) {
	return phoneService.findByTypeId(idCat);
	}



}