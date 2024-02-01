/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;


import java.util.concurrent.TimeUnit;
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

public class ListOfProductInMeatSeafoodTest {

    private WebDriver driver;
    private String baseUrl;

    public ListOfProductInMeatSeafoodTest() {
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
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/meat.html");
        
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void testAddToListButton() throws Exception {   
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");
        
        WebDriverWait wait1 =new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[automation-id='listIcon_0']")));
        driver.findElement(By.cssSelector("button[automation-id='listIcon_0']")).click();
        driver.get("https://signin.costco.com/e0714dd4-784d-46d6-a278-3e29553483eb/B2C_1A_SSO_WCS_signup_signin_567/oauth2/v2.0/authorize?ClientName=USBC&ui_locales=en-US&scope=openid+offline_access&response_type=code+id_token&redirect_uri=https%3A%2F%2Fwww.costco.com%2FOAuthLogonCmd&state=URL%3D%5BSSO%5Dhttps%3A%2F%2Fwww.costco.com%2Fmeat.html%5BSSO%5D&nonce=wlBg7V6jWHTTqAIO&client_id=4900eb1f-0c10-4bd9-99c3-c59e6c1ecebf&TC=0&response_mode=form_post");
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInHeader")));
        //assertEquals(driver.findElement(By.id("signInHeader")).getText().contains("Sign In"), true);
        assertEquals(driver.findElement(By.id("signInHeader")).getText(), "Sign In");
        
        
    }
    
    @Test(priority = 2)
    public void testSelectingItem() throws Exception {

        WebDriverWait wait1 =new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Crescent Foods Halal Hand-Cut Beef, Chicken Combo Pack - 14 Total Packs, 13.5 Lbs. Total")));
        driver.findElement(By.linkText("Crescent Foods Halal Hand-Cut Beef, Chicken Combo Pack - 14 Total Packs, 13.5 Lbs. Total")).click();
        driver.get("https://www.costco.com/crescent-foods-halal-hand-cut-beef%2c-chicken-combo-pack---14-total-packs%2c-13.5-lbs.-total.product.4000149679.html");
        assertEquals(driver.findElement(By.id("product-details")).getText().contains("Crescent Foods Halal Hand-Cut Beef, Chicken Combo Pack - 14 Total Packs, 13.5 Lbs. Total"), true);
       
    }
    
    @Test
    public void testQuickViewPopup() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.costco.com/meat.html");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        
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
