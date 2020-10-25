package com.darwinjacob.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// test1: testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}

	// test2: testing @RequestParam 'method' attributes
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}

	// test3: testing @RequestParam fall back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value="*", method = RequestMethod.GET, RequestMethod.POST)
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	// test4: testing @RequestMapping 'defaultValue' attribute
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";

	}

	// test5: testing @RequestParam without 'name' or 'value' attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}

	// test6: subtest 1: Testing @RequestMapping ambiguity with the same base URI
	// but with different parameter
	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// test6: subtest 2: Testing @RequestMapping ambiguity with the same base URI
	// but with different parameter
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}

	// test6: subtest 3: Testing @RequestMapping with multiple request param
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest3(@RequestParam String orgname, @RequestParam String empcount,
			Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}

	// test6: subtest 4: Testing @RequestMapping with multiple request param and @RequestParam with single Param
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");
		return "requestMappingAndParamResults2";
	}

	// test7 & 8: subtest 4: Testing @RequestMapping with multiple request URI's
	@RequestMapping(value = {"/test7", "/test8"} , method = RequestMethod.GET)
	public String requestMappingAndParamTest7and8(@RequestParam String orgname, Model model, HttpServletRequest request) {
		model.addAttribute("orgname", orgname);
		LOGGER.info(request.getRequestURL().toString());
		if(request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testserial" , "test7");
		} else {
			model.addAttribute("testserial", "test8");
		}
		return "requestMappingAndParamResults2";
	}



}
