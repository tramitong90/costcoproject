package test.com;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author navat
 */
public class FileUtil {

    public static LogIn ReadLogin() throws Exception {
        LogIn ln = null;
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\navat\\OneDrive\\Desktop\\bootcamp\\Selenium\\login.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet Sheet1 = workbook.getSheetAt(0);
        Row r = Sheet1.getRow(0);
        Cell c = r.getCell(1); //username value
        String username = c.getStringCellValue();
        System.out.println("username =" + username);
        r = Sheet1.getRow(0);
        c = r.getCell(1); //password value
        String password = c.getStringCellValue();
        System.out.println("password =" + password);
        ln = new LogIn(username, password); 
        return ln;
    }
}
