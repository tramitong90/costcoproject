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
public class FileUtil1 {
    
    public static Travel getData() throws FileNotFoundException, IOException{
        
        FileInputStream inputStream = new FileInputStream(new File("D:\\Data\\travelDetails.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Row r = firstSheet.getRow(1);
        Cell c = r.getCell(0);
        String destinations = c.getStringCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(1);
        String checkIn = c.getStringCellValue() + "";
        
        r = firstSheet.getRow(1);
        c = r.getCell(2);
        String checkOut = c.getStringCellValue() + "";
        
        r = firstSheet.getRow(1);
        c = r.getCell(3);
        String room = c.getStringCellValue() +"";
        
        r = firstSheet.getRow(1);
        c = r.getCell(4);
        String adult = c.getStringCellValue()+"";
        
        r = firstSheet.getRow(1);
        c = r.getCell(5);
        String children = c.getStringCellValue() +"";
        
        r = firstSheet.getRow(1);
        c = r.getCell(6);
        String ageChild1 = c.getStringCellValue() +"";
        
        r = firstSheet.getRow(1);
        c = r.getCell(7);
        String ageChild2 = c.getStringCellValue() +"";
        
        r = firstSheet.getRow(1);
        c = r.getCell(8);
        String ageChild3 = c.getStringCellValue()+"";
        
        Travel travel = new Travel(destinations, checkIn, checkOut, room, adult, children, ageChild1, ageChild2, ageChild3);
        
        inputStream.close();
        return travel;
    }
}
