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
public class SaveForLaterTest {
    private WebDriver driver;
    private String baseUrl;
    
    public SaveForLaterTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/great-southern-grass-fed-beef%2c-all-natural%2c-antibiotic-free%2c-ribeye-steaks%2c-1412-oz.-each-steak%2c-14-total-packs%2c-10.5-lbs.-total.product.100229389.html");
        
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
    
    @Test (priority = 1)
    public void testSaveForLater() throws Exception {
        
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
        driver.findElement(By.id("add-to-cart-btn")).click();
        
       // WebDriverWait wait1 =new WebDriverWait(driver, 20);
        WebDriverWait wait2 = new WebDriverWait(driver, 25);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        driver.findElement(By.linkText("View Cart")).click();
       
        driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=Ohir3LGY423kfUG7b%2FHCDrX7AF9s3LKBmOjoSd0ZJ3PW6w%2Bxh2pOgY%2BsEye6eBOga7DNu%2FDVBVrx%2FRof6txRySZ1MSxvbfWVo7cd1p9TM6U%3D&ddkey=http%3ACheckoutCartView");
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[automation-id='saveForLaterLink_1']")));
        driver.findElement(By.cssSelector("button[automation-id='saveForLaterLink_1']")).click();
       
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[automation-id = 'shoppingCartEmpty']")));
        assertEquals(driver.findElement(By.cssSelector("div[automation-id = 'shoppingCartEmpty']")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."), true);
        assertEquals(driver.findElement(By.cssSelector("h2[automation-id = 'savedForLaterLabel']")).getText(), "Saved for Later");
        assertEquals(driver.findElement(By.linkText("Great Southern Grass Fed Beef, All Natural, Antibiotic Free, Ribeye Steaks, (14/12 Oz. Each Steak), 14 Total Packs, 10.5 Lbs. Total")).getText(), "Great Southern Grass Fed Beef, All Natural, Antibiotic Free, Ribeye Steaks, (14/12 Oz. Each Steak), 14 Total Packs, 10.5 Lbs. Total");
        assertEquals(driver.findElement(By.cssSelector("button[automation-id = 'moveToCartLink_0']")).getText(), "Move to Cart");
    }
    
    @Test (priority = 2)
    public void testRemoveFromSaveForLater() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
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
        
        //another way to verify
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
