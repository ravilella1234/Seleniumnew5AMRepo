package com.excelDataReader;

public class DoubleArray 
{

	public static void main(String[] args) 
	{
		/*
		 * int[] a=new int[3]; a[0]=10; a[1]=20; a[2]=30; for(int i=0;i<a.length;i++) {
		 * System.out.println(a[i]); }
		 */
		
		
		Object[][] a1=new Object[2][2];
		a1[0][0]=10;
		a1[0][1]=20;
		a1[1][0]=30;
		a1[1][1]=40;
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(a1[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
					
		
	}

}
