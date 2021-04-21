package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class RelationshipController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public RelationshipController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping(value="/persons/{id}", method=RequestMethod.GET)
	public String displayProfile(Model model, @PathVariable("id") Long id) {
		Person p = personService.findPerson(id);
		model.addAttribute("person", p);
		return "profile.jsp";
	}

	
	@RequestMapping("/persons/new")
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		return "person.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		model.addAttribute("license", new License());
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	@RequestMapping(value="/persons/create", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "person.jsp";
		}
		else {
			Person p = personService.createPerson(person);
			return "redirect:/persons/" + p.getId();
		}
	}
	
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		}
		else {
			License l = licenseService.createLicense(license);
			return "redirect:/persons/" + l.getPerson().getId();
		}
	}
	
	
	
}
