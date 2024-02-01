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
public class HomePageFile {
    
    public static HomePage getDataHomePage() throws FileNotFoundException, IOException{
        
        FileInputStream inputStream1 = new FileInputStream(new File("D:\\Data\\homepage.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream1);
        
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Row r = firstSheet.getRow(1);
        Cell c = r.getCell(0);
        String menu = c.getStringCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(1);
        String url = c.getStringCellValue();
        
        HomePage homepage = new HomePage(menu, url);
        
        inputStream1.close();
        return homepage;
    }
}
