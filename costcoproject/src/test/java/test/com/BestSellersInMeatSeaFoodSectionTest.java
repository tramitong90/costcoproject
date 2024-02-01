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

public class BestSellersInMeatSeaFoodSectionTest {

    private WebDriver driver;
    private String baseUrl;

    public BestSellersInMeatSeaFoodSectionTest() {
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        baseUrl = "https://www.google.com/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/meat.html");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testSelectingItem() throws Exception {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("image0")));
        driver.findElement(By.id("image0")).click();
        driver.get("https://www.costco.com/.product.100393370.html");
        
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[1]/div/div[1]/h1")).getText().contains("Northwest Fish Wild Alaskan Sockeye Salmon Fillets Total 25 Count, 1 Case Totaling 10 Lbs."), true);
    }
    
    @Test(priority = 2)
    public void testItemDescription() throws Exception {
   
        //driver.findElement(By.id("image0"));
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Northwest Fish Wild Alaskan Sockeye Salmon Fillets Total 25 Count, 1 Case Totaling 10 Lbs.")));
        assertEquals(driver.findElement(By.linkText("Northwest Fish Wild Alaskan Sockeye Salmon Fillets Total 25 Count, 1 Case Totaling 10 Lbs.")).getText().contains("Northwest Fish Wild Alaskan Sockeye Salmon Fillets Total 25 Count, 1 Case Totaling 10 Lbs."), true);
    }

}
