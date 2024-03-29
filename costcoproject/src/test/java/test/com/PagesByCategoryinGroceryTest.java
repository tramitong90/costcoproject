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

public class PagesByCategoryinGroceryTest {

    private WebDriver driver;
    private String baseUrl;

    public PagesByCategoryinGroceryTest() {
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
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        
    }

    @Test
    public void testBeefPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/beef.jpg')]")));
        driver.findElement(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/beef.jpg')]")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Beef"), true);
        driver.navigate().back();
    }

    @Test
    public void testLambPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[6]/a/div/div/div/img")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[6]/a/div/div/div/img")).click();
        
        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Lamb"), true);
        driver.navigate().back();
    }

    @Test
    public void testPlantBasedProteinPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[17]/a/div/div/div/img")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[17]/a/div/div/div/img")).click();

        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Plant Based Protein"), true);
        driver.navigate().back();
    }

    @Test
    public void testPorkPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[3]/a/div/div/div/img")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[3]/a/div/div/div/img")).click();

        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Pork"), true);
        driver.navigate().back();
    }

    @Test
    public void testPoultryPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[8]/a/div/div/div/img")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[8]/a/div/div/div/img")).click();

        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Poultry"), true);
        driver.navigate().back();
    }

    @Test
    public void testSeaFoodPage() throws Exception {

        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[12]/a/div/div/div/img")));       
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[12]/a/div/div/div/img")).click();

        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Seafood"), true);
        driver.navigate().back();
    }

    @Test
    public void testGameMeatPage() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[14]/a/div/div/div/img")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div[2]/div[2]/div[14]/a/div/div/div/img")).click();

        assertEquals(driver.findElement(By.id("category-name-header")).getText().contains("Meat & Seafood"), true);
        driver.navigate().back();
    }

}
