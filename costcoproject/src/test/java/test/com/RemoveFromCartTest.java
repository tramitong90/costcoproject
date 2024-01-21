/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;
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
public class RemoveFromCartTest {

    private WebDriver driver;
    private String baseUrl;

    public RemoveFromCartTest() {
    }

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
    public void testRemoveFromCart() {
        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div[5]/div[5]")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")));
        driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
        driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[5]/div[1]/form/div/div/div/div/div/div[1]/div[2]/div[1]/div[4]/button/span")).click();

        assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."), true);
       
        assertEquals(driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div/div[4]/nav/ul/li[4]/a/div/div/span")).getText().equalsIgnoreCase("0"), true);

        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RemoveFromCartTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
