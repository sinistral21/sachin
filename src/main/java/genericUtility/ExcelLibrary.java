package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelLibrary {

	/**
	 * This method is used to read the data from excel based on below arguments
	 * @author sachin
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        String data = row.getCell(celNum).getStringCellValue();
        wb.close();
        return data;
	}
	/**
	 * This method is used to get the last used row number on specified sheet
	 * @author sachin
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();	
	}
	
	
}
