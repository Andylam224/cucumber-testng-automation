package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	public static void main(String[] args) throws Exception {
		String filePath="\\C:\\Users\\Andy\\Desktop\\Employees.xlsx";
		
		//open file and convert to a stream of data
		FileInputStream inStream=new FileInputStream(filePath);
		//take the stream of data and use it as WorkBook
		//assign data to it
		Workbook workbook=WorkbookFactory.create(inStream);
		//get the first worksheet from the workbook
		Sheet worksheet=workbook.getSheetAt(0);
		//go to first row
		//you can also use getSheetAt(name);
		Row row=worksheet.getRow(0);
		Cell cell =row.getCell(0);
		//0=first cell
		
		System.out.println(cell.toString());
		//prints FirstName
		
		//find out how many rows in Excel sheet
		int rowsCount=worksheet.getPhysicalNumberOfRows();
		//or you can use getLastRowNum(); starts from 0
		System.out.println("basic number of rows "+ rowsCount);
		
		for(int rowNum=1;rowNum<rowsCount;rowNum++) {
			row=worksheet.getRow(rowNum);
			cell=row.getCell(0);
			System.out.println(rowNum+" - "+cell.toString());
			//System.out.println(rowNum+" - "+worksheet.getRow(rowNum).getCell(0));
		}
		//print the id of Nancy
		Row Nancyrow=worksheet.getRow(5);
		System.out.println(Nancyrow.getCell(2));
		
		//now find it via loop
		for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++) {
			Row myrow=worksheet.getRow(i);
			if(myrow.getCell(0).toString().equals("Nancy")) {
				System.out.println("Nancy works as " +myrow.getCell(2).toString());
				break;
			}
		}
		
		
		workbook.close();
		inStream.close();
		
	}

}
