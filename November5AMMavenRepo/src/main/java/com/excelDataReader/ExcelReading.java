package com.excelDataReader;

public class ExcelReading 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		System.out.println(e1.getCellData("login", 0, 3));
		
		System.out.println(e1.getCellData("login", "Password", 2));
		
		
		e1.setCellData("login", 4, 1, "Passed");
		
	}

}
