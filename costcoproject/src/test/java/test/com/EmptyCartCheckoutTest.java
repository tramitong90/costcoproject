/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

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
 * @author pahan
 */
//mi add comment here
public class EmptyCartCheckoutTest {
  private WebDriver driver;
  private String baseUrl;
    public EmptyCartCheckoutTest() {
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
        driver.close();
    }
    
     @Test
  public void testCart() throws Exception {
   
    driver.get("https://www.costco.com/.product.100986522.html");
    driver.manage().window().maximize();
    driver.findElement(By.id("add-to-cart-btn")).click();
    WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
    driver.findElement(By.linkText("View Cart")).click();
    //driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=iU7jfrmm6QnqSZ3s1Cte7sDJ5YRSEhyy2LUAdunEZ%2Fyb4ub5jBFshMyEYG%2FCeteJaYzwSSFgYDYd%2BEUCxV4AvqyBhDWXdA6IWD7aKVcqYlk%3D&ddkey=http%3ACheckoutCartView");
    driver.findElement(By.id("sub-1")).click();
    driver.get("https://www.costco.com/CheckoutCartDisplayView?catalogId=10701&storeId=10301&langId=-1&krypto=jbSaaPDEX1bUwvOmrOSw%2BPke0ezg0lyqAabglBSx%2BS12dxg8U5WSAVZ34gIhCV34%2BfPpfYVAvUq8Rj6JKNzLvmyZAaxcvFZzE0hG2qFD65c%3D&ddkey=http%3ACheckoutCartView");
  
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."), true);
    assertEquals(driver.findElement(By.id("cart-d")).getText().contains("0"), true);
  }

  }
    

