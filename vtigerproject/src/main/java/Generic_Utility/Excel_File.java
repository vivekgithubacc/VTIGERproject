package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_File 
{
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh= book.getSheet("product");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		return data;
	}
	public String getExcelData1(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src/test/resources/prodelete.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh= book.getSheet("prodelt");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		return data;
	}
	public String getExcelData2(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src/test/resources/Book1Excel.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh= book.getSheet("organisation");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		return data;
	}
	public String getExcelData3(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src/test/resources/Book3.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh= book.getSheet("camp");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		return data;
		
	}
	public String getExcelData4(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CreatePandCam.xlsx");
		Workbook  book= WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("createPROD");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String productedata = cell.getStringCellValue();
		return productedata;
	}
	public String getExcelData5(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis3=new FileInputStream("./src/test/resources/ComboORGandPRO.xlsx");
		Workbook  book3= WorkbookFactory.create(fis3);
		Sheet sh3 = book3.getSheet("OrgP");
		Row row3 = sh3.getRow(0);
		Cell cell3= row3.getCell(0);
		String data3 = cell3.getStringCellValue();
		return data3;
	}
	public String getExcelData6(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src/test/resources/Book4.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh= book.getSheet("conorgs");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		return data;
		
	}
	public String getExcelData7(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis2= new FileInputStream("./src/test/resources/Book5.xlsx");
		Workbook book2 = WorkbookFactory.create(fis2);
		Sheet sh2= book2.getSheet("corgnsaton");
		Row row2=sh2.getRow(0);
		Cell cell2=row2.getCell(0);
		String data2=cell2.getStringCellValue();
		return data2;
	}
}
