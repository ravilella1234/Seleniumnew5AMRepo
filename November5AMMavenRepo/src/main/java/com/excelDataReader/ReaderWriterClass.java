package com.excelDataReader;

public class ReaderWriterClass 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		int rcount = e1.getRowCount("login");
		System.out.println("Row count is :" + rcount);
		
		int cCount = e1.columnCount("login");
		System.out.println("Column count is :" + cCount);
		
		System.out.println(e1.getCellData("login", 1, 2));
		
		System.out.println(e1.getCellData("login", "UserName", 2));
		
		e1.setCellData("login", 4, 3, "Passed");

	}

}
