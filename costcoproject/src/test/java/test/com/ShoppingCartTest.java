/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
 * @author mitra
 */
public class ShoppingCartTest {

    private WebDriver driver;
    private String baseUrl;

    public ShoppingCartTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/");

    }

    @AfterClass
    public void tearDownClass() throws Exception {
        driver.close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testAddToCart() throws Exception {

        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();

        driver.findElement(By.id("search-field")).sendKeys("apple watch");
        driver.findElement(By.id("formcatsearch")).submit();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);  //20 sec
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div/div[2]/div[2]/a/div")));
        driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/div[2]/div/div/div[2]/div[2]/a/div")).click();
        driver.findElement(By.id("addbutton-0")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
        driver.findElement(By.id("add-to-cart-btn")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        driver.findElement(By.linkText("View Cart")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple Watch Series 9 (GPS)")));
        assertEquals(driver.findElement(By.linkText("Apple Watch Series 9 (GPS)")).getText().equalsIgnoreCase("Apple Watch Series 9 (GPS)"), true);
        assertEquals(driver.findElement(By.id("quantity_1")).getAttribute("value"), "1");
    }

    @Test(dependsOnMethods = {"testAddToCart"})
    public void testModifyingCartItemsAdd() throws Exception {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("add-1"))).build().perform();
        driver.findElement(By.id("add-1")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_1")));
        assertEquals(driver.findElement(By.id("quantity_1")).getAttribute("value"), "2");

        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"testModifyingCartItemsAdd"})
    public void testModifyingCartItemsDecrease() throws Exception {
        WebDriverWait wait2 = new WebDriverWait(driver, 25);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sub-1\"]/img")));

        driver.findElement(By.xpath("//*[@id=\"sub-1\"]/img")).click();

        //wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("sub-1")));
        assertEquals(driver.findElement(By.id("quantity_1")).getAttribute("value"), "1");

        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"testModifyingCartItemsDecrease"})
    public void testCartBoundary() throws Exception {

        driver.findElement(By.id("quantity_1")).click();
        driver.findElement(By.id("quantity_1")).clear();
        driver.findElement(By.id("quantity_1")).sendKeys("999");
        driver.findElement(By.id("cart-body")).click();

        By locator = By.xpath("//*[@id=\"errquantity_\"]/p[2]");
        WebDriverWait wait1 = new WebDriverWait(driver, 10, 1000);
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        assertEquals(element.getText().contains("Item 1698456 has a maximum order quantity of 2"), true);
        driver.navigate().refresh();
    }
    
    @Test(dependsOnMethods = {"testCartBoundary"})
    public void testAddToList() throws Exception {
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,300)");
        WebDriverWait w2 = new WebDriverWait(driver, 10);
        w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-item_1\"]/div/div[5]/div[1]/button[1]")));
        
        driver.findElement(By.xpath("//*[@id=\"order-item_1\"]/div/div[5]/div[1]/button[1]")).click();
        
       
        w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInHeader\"]")));
        WebElement z = driver.findElement(By.xpath("//*[@id=\"signInHeader\"]"));
        try {
            assertEquals("Sign In", z.getText());
        } catch (Error e) {
            fail(e.toString());
        }
        //((JavascriptExecutor)driver).executeScript("window.history.go(-1)", new Object[0]);
        driver.navigate().back();
        Thread.sleep(4000);
    }

}
