package excelutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import GenericRepository.FrameworkConstant;

/**
 * This class is used to provide the utility methods to handle excel file
 *
 *
 * @author krant
 *
 **/
public class ReadExcelFile implements FrameworkConstant {
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public Workbook wb = null;

	public String readData(String sheet, int row, int column) throws IOException  {
		// Step 1:convert physical file to java readable object by using
		// FileInputStream class

	
			fis = new FileInputStream(excelpath);
		

		// Step 2:open the workbook by creating workbook factory
	
			wb = WorkbookFactory.create(fis);
		
		// Step 3:Fetch the data
		String data = wb.getSheet(sheet).getRow(row).getCell(column).toString();

		// Step 4:Close the workbook
	
			wb.close();
		return data;
	}

	public void writeData(String sheet1, int row1, int column1) {

		// step1: Convert the physical file into java readable object by using
		// FileInputStream
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// step2: Open the workbook by creating WB-factory
		try {
			wb = WorkbookFactory.create(fis);

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// step3: write the data
		wb.createSheet().createRow(row1).createCell(column1).setCellValue("");

		// step4: convert the Readable object into physical file using FileOuputStream
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// step5: save the data
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step6: close the workbook
		try {
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String updateData(String sheet, int row, int column) {
		// Step1:Convert physical file into java readable object By using
		// FileInputStream Class
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// step2:open the workbook By creating wb-factory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Step3:write the data
		wb.getSheet(sheet).createRow(row).createCell(column).setCellValue("data");
		// Step4: close the workbook
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;

	}

}
