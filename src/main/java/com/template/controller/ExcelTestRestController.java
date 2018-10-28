package com.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelTestRestController {

	private static final Logger log = LoggerFactory.getLogger(ExcelTestRestController.class);
	
	
	
	@RequestMapping(value="/excelDownLoad")
	public void excelDownLoad() {
		
	}
}
