package com.seleniumtraining.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LearnExcelDatas {
	@Test
	public void FetchExcelData() throws Exception {
		
		System.out.println("The sheet index is ");
		
		FileInputStream excel = new FileInputStream("D:\\Practice\\test.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(excel);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int TotalRows = sheet.getLastRowNum();
		
		int Totalcolumns = sheet.getRow(TotalRows).getLastCellNum();
		
		System.out.println(TotalRows +"and "+ Totalcolumns);
		
		for(int i = 0;i<=TotalRows;i++) {
			
			for(int j = 0;j< Totalcolumns;j++) {
				
			XSSFCell cellvalue =	sheet.getRow(i).getCell(j);
			
			DataFormatter df = new DataFormatter();
			String value = df.formatCellValue(cellvalue);
				if(value.equals("Rava")) {
					String Quantity =	sheet.getRow(i).getCell(j+1).getStringCellValue();
					XSSFCell PriceCell    =    sheet.getRow(i).getCell(j+2);
				
					String Price = df.formatCellValue(PriceCell);
					
					System.out.println("The product is "+value+" qty is "+ Quantity +" price is "+Price );
					
				}
			}
		}
			
	}
	
}

