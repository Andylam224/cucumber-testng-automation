package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
public static void main(String[] args) throws Exception {
	String testDataPath="./src/test/resources/testdata/Employees.xlsx";
	
	//create fileinputstream
	
	FileInputStream inStream=new FileInputStream(testDataPath);
	Workbook workbook=WorkbookFactory.create(inStream);
	Sheet worksheet=workbook.getSheet("Sheet1");
	
	Cell job=worksheet.getRow(6).getCell(2);
	//change it to "Automation Architect" via setCellValue
	job.setCellValue("Automation Architect");
	
	//save changes
	//create FileOutputStream
	FileOutputStream outStream=new FileOutputStream(testDataPath);
	//ask the workbook to write the whole thing out
	workbook.write(outStream);
	//must close the files
	outStream.close();
	workbook.close();
	//these changes will affect only the excel file inside eclipse. NOT THE DESKTOP ONE
	inStream.close();
	
}
}
