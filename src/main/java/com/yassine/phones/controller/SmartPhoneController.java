package com.yassine.phones.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;
import com.yassine.phones.service.PhoneService;

import jakarta.validation.Valid;

@Controller
public class SmartPhoneController {

	@Autowired
	PhoneService smartPhoneService;
	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
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
	public String showCreate(ModelMap modelMap) {
		List<Type> typ = smartPhoneService.getAllTypes();
		modelMap.addAttribute("smartPhone", new SmartPhone());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("type", typ);

		return "formePhone";
	}

	@RequestMapping("/saveSmartPhone")
	public String saveSmartPhone(@Valid SmartPhone phone, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size, ModelMap modelMap) {
		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) {
			List<Type> typ = smartPhoneService.getAllTypes();
			modelMap.addAttribute("type", typ);
			modelMap.addAttribute("phones", phone);
			return "formePhone";
			}
		if (phone.getId() == null) // ajout
			isNew = true;
		    smartPhoneService.saveSmartPhone(phone);
		if (isNew) // ajout
		{
			Page<SmartPhone> prods = smartPhoneService.getAllPhonesParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else // modif
			currentPage = page;

		// Ajouter la liste des types de smartphones dans le modèle
		

		return ("redirect:/ListePhones?page=" + currentPage + "&size=" + size);
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

	@RequestMapping("/editerSmartPhone")
	public String editerSmartPhone(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		SmartPhone phone = smartPhoneService.getSmartPhone(id);
		List<Type> typ = smartPhoneService.getAllTypes();

		modelMap.addAttribute("smartPhone", phone);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("type", typ);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formePhone";
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
