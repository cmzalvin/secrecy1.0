package com.egov.secrecysystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.egov.secrecysystem.service.ExcelUtilService;

@Controller
public class ExcelUtilController {
	
	private Logger logger= LoggerFactory.getLogger(ExcelUtilController.class);
	@Autowired
	private ExcelUtilService excelUtilService;
	

	
	
		
	

}
