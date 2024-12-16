package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUti {

	 private static String filePath;

	    // Method to create an Excel file with the current timestamp
	    public static String createExcelFile() {
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        filePath = "ExcelFile_" + timeStamp + ".xlsx";

	        try (Workbook workbook = new XSSFWorkbook();
	             FileOutputStream outputStream = new FileOutputStream(filePath)) {

	            workbook.createSheet("Sheet1");
	            workbook.write(outputStream);
	            System.out.println("Excel file created: " + filePath);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return filePath;
	    }

	    // Method to add data to the Excel file
	    public static void addDataToExcel(String filePath, String sheetName, int rowNumber, int colNumber, String data) {
	        try (FileInputStream inputStream = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(inputStream)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                sheet = workbook.createSheet(sheetName);
	            }

	            Row row = sheet.getRow(rowNumber);
	            if (row == null) {
	                row = sheet.createRow(rowNumber);
	            }

	            Cell cell = row.getCell(colNumber);
	            if (cell == null) {
	                cell = row.createCell(colNumber);
	            }

	            cell.setCellValue(data);

	            // Write the updated workbook back to the file
	            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
	                workbook.write(outputStream);
	                System.out.println("Data added successfully to " + filePath);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
