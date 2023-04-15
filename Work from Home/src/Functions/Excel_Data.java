package Functions;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public Excel_Data() {

		try {

			File src = new File(".//2000 Form set (GHM).xlsx");
			FileInputStream inputstream = new FileInputStream(src);
			wb = new XSSFWorkbook(inputstream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public XSSFCell getData(int sheetnumber, int row, int column) {

		sheet = wb.getSheetAt(sheetnumber);

		XSSFCell Data = sheet.getRow(row).getCell(column);
		return Data;
	}

	public String getDate(int sheetnumber, int row, int column) {

		sheet = wb.getSheetAt(sheetnumber);

		Cell cell = sheet.getRow(row).getCell(column);

		DateFormat df = new SimpleDateFormat("M/d/yyyy");

		// Get the date today using cell.getDateCellValue()
		Date date = cell.getDateCellValue();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String reportDate = df.format(date);
		return reportDate;
	}
}