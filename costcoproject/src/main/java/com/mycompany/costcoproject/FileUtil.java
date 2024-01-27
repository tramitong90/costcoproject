/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.costcoproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author mitra
 */
public class FileUtil {
    
    public static Travel getData() throws FileNotFoundException, IOException{
        
        FileInputStream inputStream = new FileInputStream(new File("D:\\Data\\productdetails.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Row r = firstSheet.getRow(1);
        Cell c = r.getCell(0);
        String destinations = c.getStringCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(1);
        String checkIn = c.getNumericCellValue() + "";
        
        r = firstSheet.getRow(1);
        c = r.getCell(2);
        String checkOut = c.getStringCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(3);
        double room = c.getNumericCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(4);
        double adult = c.getNumericCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(5);
        double children = c.getNumericCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(6);
        double ageChild1 = c.getNumericCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(7);
        double ageChild2 = c.getNumericCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(8);
        double ageChild3 = c.getNumericCellValue();
        
        Travel travel = new Travel(destinations, checkIn, checkOut, room, adult, children, ageChild1, ageChild2, ageChild3);
        
        
        return travel;
    }
}
