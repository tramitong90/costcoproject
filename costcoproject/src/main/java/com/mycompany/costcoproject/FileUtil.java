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
    
    public static Product getData() throws FileNotFoundException, IOException{
        
        
        
        FileInputStream inputStream = new FileInputStream(new File("D:\\Data\\productdetails.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Row r = firstSheet.getRow(1);
        Cell c = r.getCell(0);
        String name = c.getStringCellValue();
        
        r = firstSheet.getRow(1);
        c = r.getCell(1);
        String price = c.getNumericCellValue() + "";
        
        r = firstSheet.getRow(1);
        c = r.getCell(2);
        String description = c.getStringCellValue();
        
        Product product = new Product(name, price, description);
        
        
        return product;
    }
}
