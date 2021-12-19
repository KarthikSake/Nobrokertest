package com.nobroker.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	Workbook book;
	
	public ExcelReader(String locationwithFileName)  {
		try {
		FileInputStream ip=new FileInputStream(locationwithFileName);
		if(locationwithFileName.endsWith(".xlsx")){
		 book=new XSSFWorkbook(ip);
		}
		else if (locationwithFileName.endsWith(".xls"))
		{
			 book=new HSSFWorkbook(ip);
		}
		else
		{
		System.out.println("Invalid file type");
		}
		}
		catch(Exception e)
		{
			System.out.println("Error with reading the file");
		}
		
	}
	
	public String getCellData(String sheetname,int row,int col)
	{Cell data=book.getSheet(sheetname).getRow(row).getCell(col,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
	String c;
	if (data == null) {
         c="";
     } else {
         c=data.toString();
     }
	return c;
	}
	
	public int rownum(String sheetname)
	{
		int a=book.getSheet(sheetname).getLastRowNum();
		return a+1;
	}

}
	
	

