/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import com.mycompany.costcoproject.HomePageFile;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
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
public class CheckingLinkToPhotoCategoryTest {

    private WebDriver driver;
    private String baseUrl;

    public CheckingLinkToPhotoCategoryTest() {
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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();

    }
    @Test
    public void testCheckingLinkToPhotoCategory() throws InterruptedException, IOException {
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/");

        //Thread.sleep(5000);
        WebElement element = driver.findElement(By.id(HomePageFile.getDataHomePage().getMenu()));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        action.click().build().perform();

        String actualPage = driver.getCurrentUrl();
        String expectedPage = HomePageFile.getDataHomePage().getUrl();
        assertEquals(actualPage, expectedPage);

    }

//    @Test
//    public void testCheckingLinkToPhotoCategory() throws InterruptedException {
//        driver.get("https://www.costco.com/");
//        driver.manage().window().maximize();
//
//        Thread.sleep(5000);
////        WebDriverWait wait = new WebDriverWait(driver, 25);
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Photo']")));
//        WebElement element = driver.findElement(By.xpath("//a[text()='Photo']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(element).build().perform();
//        action.click().build().perform();
//
//        String actualPage = driver.getCurrentUrl();
//        String expectedPage = "https://www.costco.com/photo.html";
//        assertEquals(actualPage, expectedPage);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(CheckingLinkToPhotoCategoryTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        driver.close();
//
//    }

}
