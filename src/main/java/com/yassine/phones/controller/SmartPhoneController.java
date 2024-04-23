package com.yassine.phones.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.service.PhoneService;

@Controller
public class SmartPhoneController {

	@Autowired
	PhoneService smartPhoneService;

	@RequestMapping("/ListePhones")
	public String listePhones(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<SmartPhone> phons = smartPhoneService.getAllPhonesParPage(page, size);
		modelMap.addAttribute("phones", phons);
		modelMap.addAttribute("pages", new int[phons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeSmartPhones"; // Assuming you have a Thymeleaf template named "listeSmartPhones.html"
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "formPhone";
	}

	@RequestMapping("/saveSmartPhone")
	public String saveSmartPhone(@ModelAttribute("smartPhone") SmartPhone smartPhone, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateFormat.parse(date);
		smartPhone.setDateCreation(dateCreation);

		SmartPhone savedSmartPhone = smartPhoneService.saveSmartPhone(smartPhone);
		String msg = "SmartPhone enregistré avec Id " + savedSmartPhone.getId();
		modelMap.addAttribute("msg", msg);
		return "createSmartPhone";
	}

	@RequestMapping("/supprimerPhones")
	public String supprimerPhones(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		smartPhoneService.deleteSmartPhoneById(id);

		Page<SmartPhone> phons = smartPhoneService.getAllPhonesParPage(page, size);
		modelMap.addAttribute("phones", phons);
		modelMap.addAttribute("pages", new int[phons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSmartPhones";
	}

	@RequestMapping("/modifierSmartPhone")
	public String editerSmartPhone(@RequestParam("id") Long id, ModelMap modelMap) {
		SmartPhone phone = smartPhoneService.getSmartPhone(id);
		modelMap.addAttribute("smartPhone", phone);
		return "editerSmartPhone";
	}

	@RequestMapping("/updateSmartPhone")
	public String updateSmartPhone(@ModelAttribute("smartPhone") SmartPhone smartPhone,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateFormat.parse(date);
		smartPhone.setDateCreation(dateCreation);

		smartPhoneService.updateSmartPhone(smartPhone);
		List<SmartPhone> phones = smartPhoneService.getAllSmartPhones();
		modelMap.addAttribute("smartPhones", phones);
		return "listeSmartPhones";
	}
}
