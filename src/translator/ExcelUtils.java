package translator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
		String[][] array = new String[myList.size()][myList.get(0).size()];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				array[i][j]=myList.get(i).get(j);
			}
		}
		
		return array;
	}

	
	
	public void writeExcel(String filePath, String sheetName, Object[][] dataTypes){try {
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet;
        try{
        	sheet = workbook.createSheet(sheetName);
        }
        catch(Exception e){
        	sheet = workbook.getSheet(sheetName);
        }
       

        int rowCount = sheet.getLastRowNum();

        for (Object[] aBook : dataTypes) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
            //cell.setCellValue(rowCount);
             
            for (Object field : aBook) {
                cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        //workbook.close();
        outputStream.close();
         
    } catch (IOException | EncryptedDocumentException
            | InvalidFormatException ex) {
        ex.printStackTrace();
    }
	}
	
	public static void main(String[] args) {
		Object[][] myData = new ExcelUtils().getExcelData("C:/Users/Mayank/Desktop/Book1.xlsx", "Sheet2");
		new ExcelUtils().writeExcel("C:/Users/Mayank/Desktop/Book1.xlsx", "Sheet3", myData);
	}
}
