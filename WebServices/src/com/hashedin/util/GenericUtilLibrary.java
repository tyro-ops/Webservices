package com.hashedin.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GenericUtilLibrary {
    public static String getCellValue(String pathOfFile, String sheetName, int rowNum, int cellNum) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(pathOfFile);
        Workbook wb = WorkbookFactory.create(fis);
        //HSSFWorkbook wb = new HSSFWorkbook(fis);
        int type = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getCellType();
        String value = "";
        if(type==Cell.CELL_TYPE_STRING){
            value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();    
        }else if(type==Cell.CELL_TYPE_NUMERIC){
            int numValue = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
            value = ""+numValue;
        }else if(type==Cell.CELL_TYPE_BOOLEAN){
            boolean boolValue =  wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
            value = ""+boolValue;
        }
        return value;
    }
    
    public static void writeData(String pathOfFile, String sheetName, int rowNum, int cellNum, String value) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(pathOfFile);
        Workbook wb = WorkbookFactory.create(fis);
        //HSSFWorkbook wb = new HSSFWorkbook(fis); 
        wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(pathOfFile);
        wb.write(fos);
    }
}