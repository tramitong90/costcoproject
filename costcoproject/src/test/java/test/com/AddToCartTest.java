/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author SK
 */
//mi add comment here
public class AddToCartTest {
    
     private WebDriver driver;
  private String baseUrl;
  
    public AddToCartTest() {
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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
         driver.close();
    }
    
     @Test
  public void testCase1() throws Exception {
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://www.costco.com/");
    driver.findElement(By.id("search-field")).click();
    driver.findElement(By.id("search-field")).clear();
    driver.findElement(By.id("search-field")).sendKeys("watch");
    WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formcatsearch")));
    
    driver.findElement(By.id("formcatsearch")).submit();
    try {
      assertEquals(driver.findElement(By.xpath("//ol[@id='crumbs_ul']/li[3]")).getText(), "Watches");
    } catch (Error e) {
        
      System.out.println(e.toString());
    }
    driver.findElement(By.xpath("//img[contains(@src,'https://mobilecontent.costco.com/live/resource/img/static-us-tiles/luxury-watches.jpg')]")).click();
    driver.findElement(By.id("sort_by")).click();
    new Select(driver.findElement(By.id("sort_by"))).selectByVisibleText("Newest");
    driver.findElement(By.id("search-field")).click();
    driver.findElement(By.id("search-field")).clear();
    driver.findElement(By.id("search-field")).sendKeys("apple watch");
    driver.findElement(By.id("formcatsearch")).submit();
    driver.findElement(By.xpath("//div[@id='search-results']/div[3]/div[2]/div/div/div[2]/div[4]/a/div")).click();
    driver.findElement(By.xpath("//img[@alt='Apple Watch SE (2nd Generation) (GPS) Sport Band']")).click();
     WebDriverWait wait1=new WebDriverWait(driver, 20);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
    driver.findElement(By.id("add-to-cart-btn")).click();
    //WebDriverWait wait2=new WebDriverWait(driver, 30);  //20 sec
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("costcoModalTitle")));
    //driver.findElement(By.id("costcoModalTitle")).click();
    //driver.findElement(By.xpath("//div[@id='costcoModal']/div/div/div/button/span")).click();
    //driver.findElement(By.id("cart-d")).click();
    //driver.findElement(By.xpath("//div[@id='order-item_1']/div/div[2]/div[2]/div/div/div/div/div[2]/div/div/label")).click();
  }

}

