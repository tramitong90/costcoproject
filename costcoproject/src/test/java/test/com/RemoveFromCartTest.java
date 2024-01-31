/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void testRemoveFromCart() throws InterruptedException {
        driver.get("https://www.costco.com/sony-85%22-class---x90cl-series---4k-uhd-led-lcd-tv---allstate-3-year-protection-plan-bundle-included-for-5-years-of-total-coverage*.product.4000186642.html");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div[5]/div[5]")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[automation-id='addToCartButton']")));
        driver.findElement(By.cssSelector("input[automation-id='addToCartButton']")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        WebElement cart = driver.findElement(By.linkText("View Cart"));
        cart.click();
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[automation-id='removeItemLink_1']")));
        driver.findElement(By.cssSelector("span[automation-id='removeItemLink_1']")).click();
        
        
        driver.navigate().refresh();
        
        //Thread.sleep(1000);
        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[automation-id='removeItemLink_2']")));
        
        WebElement element = driver.findElement(By.cssSelector("span[automation-id='removeItemLink_2']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        element.click();
        
        driver.navigate().refresh();
        Thread.sleep(2000);
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")));
        assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."), true);
       
        //assertEquals(driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div/div[4]/nav/ul/li[4]/a/div/div/span")).getText().equalsIgnoreCase("0"), true);

        assertEquals(driver.findElement(By.id("cart-d")).getText().contains("0"), true);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RemoveFromCartTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
