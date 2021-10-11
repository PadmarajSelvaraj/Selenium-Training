package com.seleniumtraining.testdata;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LearnPDFDatas {
	@Test
	public void FetchPDFData() throws Exception {
		
		System.out.println("The sheet index is ");
		
		FileInputStream pdf = new FileInputStream("D:\\Practice\\REMOVE_FAMILY_MEMBER.pdf");
		
		BufferedInputStream bf = new BufferedInputStream(pdf);
		
		PDDocument pd = PDDocument.load(bf);
		
		PDFTextStripper text = new PDFTextStripper();
		String pdfvalue = text.getText(pd);
		System.out.println(pdfvalue.contains("btatu"));
		
		
			
	}
	
}

