/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
public class SaveForLater_RemoveItemTest {

    private WebDriver driver;
    private String baseUrl;

    public SaveForLater_RemoveItemTest() {
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
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @Test
    public void testRemoveButton() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/.product.1361170.html");
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
        driver.findElement(By.id("add-to-cart-btn")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        driver.findElement(By.linkText("View Cart")).click();
        driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=gQHxU%2Fx3YwlmsmkQtl24Cbv%2B38hszhtLVq8DncH4jLufyTjaJAUGKA2fdYqa9cRgC38SttMMkODpLhKcqT9FHu%2BitGT7cXd5m%2F3WZVHwhgo%3D&ddkey=http%3ACheckoutCartView");
        
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,300)");
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[automation-id='saveForLaterLink_1']")));
        driver.findElement(By.cssSelector("button[automation-id='saveForLaterLink_1']")).click();
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sfl-items-container\"]/div/div/div/div[2]/div/div/div/div/button")));
        driver.findElement(By.xpath("//*[@id=\"sfl-items-container\"]/div/div/div/div[2]/div/div/div/div/button")).click();
        
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean notPresent;
        try{
            (driver.findElements(By.cssSelector("h2[automation-id = 'savedForLaterLabel']"))).isEmpty();
            notPresent = true;
        }catch(NoSuchElementException e){
            notPresent = false;
        }
        assertEquals(notPresent, true);
        
        //another way to varify
//        boolean isPresent;
//        try{
//            driver.findElement(By.xpath("//*[@id=\"order-items-sfl\"]/div[1]/h2")).isEnabled();
//            isPresent = true;
//        } catch (NoSuchElementException e) {
//            isPresent = false;
//        }
//        
//        assertEquals(isPresent, false);
    }

}