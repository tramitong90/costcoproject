/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
public class ModifyingCartItemsTest {

    private WebDriver driver;
    private String baseUrl;

    public ModifyingCartItemsTest() {
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
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @Test
    public void testModifyingCartItemsAdd() throws Exception {
        driver.get("https://www.costco.com/great-southern-grass-fed-beef%2c-all-natural%2c-antibiotic-free%2c-ribeye-steaks%2c-1412-oz.-each-steak%2c-14-total-packs%2c-10.5-lbs.-total.product.100229389.html");
        driver.manage().window().maximize();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
        driver.findElement(By.id("add-to-cart-btn")).click();
        
       // WebDriverWait wait1 =new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")));
        driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
       
        driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=Ohir3LGY423kfUG7b%2FHCDrX7AF9s3LKBmOjoSd0ZJ3PW6w%2Bxh2pOgY%2BsEye6eBOga7DNu%2FDVBVrx%2FRof6txRySZ1MSxvbfWVo7cd1p9TM6U%3D&ddkey=http%3ACheckoutCartView");
        driver.findElement(By.xpath("//button[@id='add-1']/img")).click();
       
        assertEquals(driver.findElement(By.id("quantity_1")).getAttribute("value"), "2");
    }
    
     @Test
    public void testModifyingCartItemsDecrease() throws Exception {
        driver.get("https://www.costco.com/great-southern-grass-fed-beef%2c-all-natural%2c-antibiotic-free%2c-ribeye-steaks%2c-1412-oz.-each-steak%2c-14-total-packs%2c-10.5-lbs.-total.product.100229389.html");
        driver.manage().window().maximize();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
        driver.findElement(By.id("add-to-cart-btn")).click();
        
        //WebDriverWait wait1 =new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")));
        driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
       
        driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=Ohir3LGY423kfUG7b%2FHCDrX7AF9s3LKBmOjoSd0ZJ3PW6w%2Bxh2pOgY%2BsEye6eBOga7DNu%2FDVBVrx%2FRof6txRySZ1MSxvbfWVo7cd1p9TM6U%3D&ddkey=http%3ACheckoutCartView");
        driver.findElement(By.xpath("//button[@id='add-1']/img")).click();
        driver.findElement(By.xpath("//button[@id='add-1']/img")).click();
        driver.findElement(By.id("sub-1")).click();
       
        assertEquals(driver.findElement(By.id("quantity_1")).getAttribute("value"), "2");
    }

}
