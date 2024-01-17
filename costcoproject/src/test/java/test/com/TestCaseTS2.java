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
public class TestCaseTS2 {

    private WebDriver driver;
    private String baseUrl;

    public TestCaseTS2() {
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
//        driver.quit();

    }

    @Test
    public void testRemoveFromCart() {//*[@id="crumbs_ul"]/li[2]/span
//        Set<String> windowHandle;

        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
//    driver.findElement(By.id("cart-d")).click();
//    driver.findElement(By.name("continue-shopping")).click();
        driver.findElement(By.xpath("//img[@alt='Mohawk Luxury Vinyl Plank Flooring']")).click();

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.id("add-to-cart-btn")).click();
// Perform the click operation that opens new window

        WebDriverWait wait1 = new WebDriverWait(driver, 20);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")));
        driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
        
        driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[5]/div[1]/form/div/div/div/div/div/div[1]/div[2]/div[1]/div[4]/button/span")).click();
        
        assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."), true);
        
//// Switch to new window opened
//for(String winHandle : driver.getWindowHandles()){
//////    driver.switchTo().window(winHandle);
////}
// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//// Perform the actions on new window
//  driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div[2]/a/button")).click();
//
//    driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
//// Close the new window, if that window no more required
////driver.close();

//// Switch back to original browser (first window)
//driver.switchTo().window(winHandleBefore);
//// Continue with original browser (first window)
//    driver.getWindowHandle();
//    windowHandle = driver.getWindowHandles();
//
//driver.switchTo().window("costcoModal");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCaseTS2.class.getName()).log(Level.SEVERE, null, ex);
        }
//   driver.close();
    }

}
