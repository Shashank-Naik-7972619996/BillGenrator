package base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {

		XSSFWorkbook wb;
		XSSFSheet sheet;

		public ExcelData() {

			try {
//System.getProperty("user.dir")+ ".\\application.properties"
				File src = new File(System.getProperty("user.dir")+ ".\\Excel Data\\All Data.xlsx");
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
}