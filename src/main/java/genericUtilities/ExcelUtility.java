package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

public String readFromExcelFile(String SheetName,int a,int b) throws IOException {
	
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

	Workbook w=WorkbookFactory.create(fis);
	Sheet s = w.getSheet(SheetName);
	Row r=s.getRow(a);
	Cell c=r.getCell(b);
	String ProductName=c.getStringCellValue();
	return ProductName;
	
}

}
