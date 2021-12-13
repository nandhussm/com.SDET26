package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Nandhu
 *
 */
public class ExcelUtility {
	/**
	 * its used to fetch the data from xcel based on arg
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
    public String getDataFromExcel(String sheetName , int rownum,int cellnum) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./orgwithindustry.xlsx");
       Workbook book = WorkbookFactory.create(fis);
       Sheet sh = book.getSheet(sheetName);
       Row r = sh.getRow(rownum);
    	String cel = r.getCell(cellnum).getStringCellValue();
    	book.close();
		return cel;  	
    }
    /**
     * its used to get the last row num on specific sheet
     * @param Sheetname
     * return
     * @throws IOException 
     */
    public int getRowCount(String Sheetname) throws IOException {
    	FileInputStream fis1 = new FileInputStream("./orgwithindustry.xlsx");
    	  Workbook book = WorkbookFactory.create(fis1);
          Sheet sh = book.getSheet(Sheetname);
          book.close();
          int lastrow = sh.getLastRowNum();
		return lastrow;
    }
    /**
     * is used to enter the data into required cell in sheet
     * @param sheetname
     * @param rownum
     * @param cellnum
     * @throws IOException 
     * @throws EncryptedDocumentException 
     */
    public void setDataExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
    	FileInputStream fis1 = new FileInputStream("./orgwithindustry.xlsx");
  	  Workbook book = WorkbookFactory.create(fis1);
        Sheet sh = book.getSheet(sheetname);
        Row ro = sh.getRow(rownum);
        Cell cel = ro.createCell(cellnum);
        cel.setCellValue(data);
        FileOutputStream fos = new FileOutputStream("./orgwithindustry.xlsx");
        book.write(fos);
        book.close();
        } 
}
