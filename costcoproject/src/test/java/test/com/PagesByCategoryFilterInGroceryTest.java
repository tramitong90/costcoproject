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

public class PagesByCategoryFilterInGroceryTest {

    private WebDriver driver;
    private String baseUrl;

    public PagesByCategoryFilterInGroceryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
 //       ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/meat.html");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        driver.close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {  
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        
    }

    @Test
    public void testBeefPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion-filter_collapse-2']/div/div[4]/a/label")));
        driver.findElement(By.xpath("//div[@id='accordion-filter_collapse-2']/div/div[4]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Beef"), true);
        
        driver.navigate().back();
    }

    @Test
    public void testLambPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[5]/a/label")));
        driver.findElement(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[5]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Lamb"), true);
        driver.navigate().back();
    }
    
    @Test
    public void testPlantBasedProteinPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[6]/a/label")));
        driver.findElement(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[6]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Plant Based Protein"), true);
        driver.navigate().back();
    }
    
    @Test
    public void testPorkPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[7]/a/label")));
        driver.findElement(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[7]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Pork"), true);
        driver.navigate().back();
    }
    
    @Test
    public void testPoultryPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[8]/a/label")));
        driver.findElement(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[8]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Poultry"), true);
        driver.navigate().back();
    }
    
    @Test
    public void testSeaFoodPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[9]/a/label")));
        driver.findElement(By.xpath("//*[@id=\"accordion-filter_collapse-2\"]/div/div[9]/a/label")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Seafood"), true);
        driver.navigate().back();
    }
    
}
