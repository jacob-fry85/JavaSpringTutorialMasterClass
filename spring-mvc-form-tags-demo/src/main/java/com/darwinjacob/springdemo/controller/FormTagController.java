package com.darwinjacob.springdemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darwinjacob.springdemo.domain.test.OrganizationRegistration;
import com.darwinjacob.springdemo.service.test.OrganizationRegistrationService;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagController {
	@Autowired
	private OrganizationRegistrationService orgRegService;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/formTagsTestViews/formTagsHome", "orgRegistration", new OrganizationRegistration());
	}
	
	@RequestMapping(value="/registerOrg", method=RequestMethod.POST)
	public ModelAndView organizationRegistration(@ModelAttribute OrganizationRegistration orgRegistration) {
		//model.addAttribute("orgreg", orgRegistration);
		return new ModelAndView("test/formTagsTestViews/formTagsResult", "orgreg", orgRegistration) ;		
	}
	
	@ModelAttribute
	public void populateFormObjectWithData(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("turnoverlist", orgRegService.populateTurnover());
		map.put("typelist", orgRegService.populateTypes());
		map.put("servicelengthlist", orgRegService.populateServiceLength());
		map.put("registeredpreviouslylist", orgRegService.populateRegisteredPreviously());
		map.put("subscriptionlist", orgRegService.populateOptionalServices());
		map.put("premiumserviceslist", orgRegService.populatePremiumServices());
		map.put("employeestrengthlist", orgRegService.populateEmployeeStrength());
	}
}
