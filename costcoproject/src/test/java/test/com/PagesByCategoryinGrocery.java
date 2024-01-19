/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class PagesByCategoryinGrocery {

    private WebDriver driver;
    private String baseUrl;

    public PagesByCategoryinGrocery() {
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
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("Home_Ancillary_0")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/21w988-grocery-category-meat.png')]")));
        driver.findElement(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/21w988-grocery-category-meat.png')]")).click();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @Test
    public void testBeefPage() throws Exception {
        
        driver.findElement(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/beef.jpg')]")).click();
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Beef"), true);
        
    }
    
    @Test
    public void testLambPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[6]/a/div/div/div/img")).click();
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Lamb"), true);
    }
    
    @Test
    public void testPlantBasedProteinPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[17]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Plant Based Protein"), true);
    }
    
    @Test
    public void testPorkPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[3]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Pork"), true);
    }
    
    @Test
    public void testPoultryPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[8]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Poultry"), true);
    }
    
    @Test
    public void testSeaFoodPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[12]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Seafood"), true);
    }
    
    @Test
    public void testGameMeatPage() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[14]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Seafood"), true);
    }
    
}
