/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.Iterator;
import java.util.Set;
import static java.util.Spliterators.iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
public class ListOfProduct_QuickViewTest {
    private WebDriver driver;
    private String baseUrl;
    public ListOfProduct_QuickViewTest() {
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
 //       ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }
    
    @Test
    public void testQuickViewPopup() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/meat.html");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"productTile_4000149679\"]/div[2]/div[1]/div/div"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        //driver.findElement(By.xpath("//div[@id='productTile_4000149679']/div[2]/div/div/div")).click();
        action.click().build().perform();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebDriverWait wait1 =new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("costcoModalTitle")));
        assertEquals(driver.findElement(By.id("costcoModalTitle")).getText(), "Quick View");
        
        
    }
}
