/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author navat
 */
public class AddtolistTest {

    private WebDriver driver;
    private String baseUrl;

    public AddtolistTest() {
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
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
         driver.quit();
    }

    @Test
    public void testList() throws Exception {
        driver.get("https://www.costco.com");
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("airpods pro (2nd generation)");
        driver.findElement(By.xpath("//form[@id='formcatsearch']/div[2]/button/i")).click();
        WebDriverWait wait=new WebDriverWait(driver, 10);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addbutton-0")));
        driver.findElement(By.id("addbutton-0")).click();
        WebDriverWait wait2=new WebDriverWait(driver, 10);  //20 sec
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-d']/div/div")));
        driver.findElement(By.xpath("//a[@id='cart-d']/div/div")).click();
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//*[@id=\"order-item_1\"]/div/div[5]/div[1]/button[1]")).click();
        WebDriverWait w2 = new WebDriverWait(driver, 10);
        w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInHeader\"]")));
        WebElement z = driver.findElement(By.xpath("//*[@id=\"signInHeader\"]"));
          try {
      assertEquals("Sign In", z.getText());
    } catch (Error e) {
      fail(e.toString());
    }

    }
}