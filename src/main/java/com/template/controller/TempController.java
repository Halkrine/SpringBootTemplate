package com.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/test")
public class TempController {

	private final static Logger log = LoggerFactory.getLogger(TempController.class);
	
	@RequestMapping(value="/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("def.test.index");
		
		return mv;
	}
	
}
