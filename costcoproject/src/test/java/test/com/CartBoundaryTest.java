/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 * @author pahan
 */
public class CartBoundaryTest {
  private WebDriver driver;
  private String baseUrl;
    public CartBoundaryTest() {
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
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    driver.close ();
    }
    
    @Test
  public void testBd() throws Exception {
    driver.get("https://www.costco.com/.product.990929.html");
    driver.manage().window().maximize();
    driver.findElement(By.id("add-to-cart-btn")).click();
    WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
    driver.findElement(By.linkText("View Cart")).click();
    driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=%2BIfV2bt2MKN%2BxiOm%2FnTMpkfEZDLSpH90jLO4dzECVwx1nJWYEUESw%2FWA%2BXVlOMHzP0HA2ENNXGDRsJG12BuCP3VPo1dMFU7KjuUSuJS2GNQ%3D&ddkey=http%3ACheckoutCartView");
    driver.findElement(By.id("quantity_1")).click();
    driver.findElement(By.id("quantity_1")).clear();
    driver.findElement(By.id("quantity_1")).sendKeys("999");
    driver.findElement(By.id("cart-body")).click();
    
//    assertEquals(driver.findElement(By.xpath("//*[@id=\\\"cart-body\\\"]\")")).WebDriverWait );
    WebDriverWait wait1 = new WebDriverWait(driver, 10, 1000);

    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"errquantity_\"]/p[2]")));
    WebElement element = driver.findElement(By.xpath("//*[@id=\"errquantity_\"]/p[2]")); 

    assertEquals(element.getText().contains("Item 990929 is out of stock or unavailable to order"), true);
    
  }
}
