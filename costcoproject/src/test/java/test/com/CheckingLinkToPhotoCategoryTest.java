/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
        
    }
    
    @Test
    public void testCheckingLinkToPhotoCategory() {//*[@id="crumbs_ul"]/li[2]/span
        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"navigation-widget\"]/div/nav/div[8]/a")).click();
    
        assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div/div[1]/div/ol/li[2]/span")).getText().contains("Photo"), true);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CheckingLinkToPhotoCategoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        driver.close();
    }

}
