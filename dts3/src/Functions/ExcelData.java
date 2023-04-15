package Functions;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelData() {
		
	try {
		
		File src = new File(".//ExcelData.xlsx");
		FileInputStream inputstream = new FileInputStream(src);
		wb = new XSSFWorkbook(inputstream);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	}
	
	public String getData(int sheetnumber , int row, int column)
	{
		sheet = wb.getSheetAt(sheetnumber);
		String Data = sheet.getRow(row).getCell(column).getStringCellValue();
		return Data;
	}
}