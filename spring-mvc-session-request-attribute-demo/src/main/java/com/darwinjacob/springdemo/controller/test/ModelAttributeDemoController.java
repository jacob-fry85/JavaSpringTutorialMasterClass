package com.darwinjacob.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darwinjacob.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);

	@RequestMapping(value = "/home")
	public String home(Model model) {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "/test/folderChangeJsp/modelAttributeHome";
	}

	// version 2 of our home() method
	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("command", new Address("Jakarta Utara", "14250"));
		return mav;
	}

	// version 3 of our home() method
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address("Jakarta Pusat", "10610"));
		return mav;
	}

	// version 4 of our home() method
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "3500"));
	}

	// version 5 of our home() method
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		return "modelAttributeHome";
	}

	
	
	
	// Test series to determine the nature of the @ModelAttribute annotation (on a
	// method)

	// Test 1: Demonstrating the usae of @ModelAttribute annotation (on a method)
	// to add multiple attributes
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributesTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("testdata1B",
				"We will test both usages of the @ModelAttribute, on methods and on method arguments");
	}

	// Test 2: Demonstrating the usage of the 'name' attribute of the
	// @ModelAtrribute annotation(on method)
	// Model Attribute nama nya = testdata2, return isinya "we will conduct a series
	// of test.."
	@ModelAttribute(name = "testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		return "We will conduct a series of test here.";
	}

	// Test 3: Demonstrating the usage of the @ModelAttribute annotation(on a
	// method) to implicitly add an attribute
	// by returning it and also demonstrating the usage of the 'value' attribute of
	// @ModelAttribute annotation(on a method)
	@ModelAttribute(value = "testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Adelaide", "3000");
	}

	// Test4: Demonstrate the default naming strategy of the @ModelAttribute
	// annotation (on a method). should be return address lowercase.
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		return new Address("Sydney", "4500");
	}
	
	// Test 5: Testing the@ModelAttribute with 'value' attribute and default binding
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		LOGGER.info("INSIDE test5 method anAddress = {}", anAddress);
		model.addAttribute("testData5", anAddress.getCity());
		model.addAttribute("testData5B", anAddress.getZipCode());
		return "modelAttributeTest";
	}
	
	//Test6: Test to determine the natre of how the @ModelAttribute(on method) and @RequestMapping
	// work with no explicit logical view name
	//because we didnt return viewname spring will use the /modelAttributeTest name to return as view
	@RequestMapping(value="/modelAttributeTest") 	
	@ModelAttribute("testdata06")
	public Address modelAtrribteTest6() {
		return new Address("Canberra", "2600");
	}
	

}
