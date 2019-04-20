package translator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	public String[][] getExcelData(String filePath, String sheetName){
		List<List<String>> myList = new ArrayList<>();
		
		try {

            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = datatypeSheet.iterator();
            while (iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                List<String> data = new ArrayList<>();
                while (cellIterator.hasNext()) {
                	Cell currentCell = cellIterator.next();
                    data.add(currentCell.getStringCellValue());
                }
                myList.add(data);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println(myList);
		
		return null;
	}

	
	public static void main(String[] args) {
		new ExcelUtils().getExcelData("C:/Users/Mayank/Desktop/Book1.xlsx", "Sheet1");
	}
}
