/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mitra
 */

public class SectionInMeatSeaFoodPageTest {
    private WebDriver driver;
    private String baseUrl;
    
    public SectionInMeatSeaFoodPageTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
 //       ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }
    
    @Test
    public void testSectionInMeatPage() throws Exception {
        driver.get("https://www.costco.com/meat.html");
        driver.manage().window().maximize();
//        WebDriverWait wait1 = new WebDriverWait(driver, 25);
////        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("Home_Ancillary_0")));
////        driver.findElement(By.id("Home_Ancillary_0")).click();
//        //WebDriverWait wait1 = new WebDriverWait(driver, 20);
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/21w988-grocery-category-meat.png')]")));
//        driver.findElement(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/21w988-grocery-category-meat.png')]")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[1]/div/h2")).getText().contains("Shop By Category"), true);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"aopt-rcmd-tt515356\"]/div[1]")).getText().contains("Best Sellers In Meat & Seafood"), true);
        //assertEquals(driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[6]/div[3]/div[2]/div/ctl:cache/div/div[2]/div/div[6]/span")).getText().contains("Showing 1-24 of 149"), true);
        
    }
}
