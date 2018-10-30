package com.template.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelTestRestController {

	private static final Logger log = LoggerFactory.getLogger(ExcelTestRestController.class);
	
	
	
	@RequestMapping(value="/excelDownLoad")
	public void excelDownLoad() throws IOException {
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("Sheet");
		
		SXSSFRow row = sheet.createRow(0);
		
		SXSSFCell cell = row.createCell(0);
		cell.setCellValue("test");
		
		FileOutputStream fos = new FileOutputStream("/Users/halkrine/temp.xlsx");
		
		workbook.write(fos);
	}
	
	@RequestMapping(value="/readExcel")
	public void readExcel() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("/Users/halkrine/temp.xlsx");
		
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		
	}
}
