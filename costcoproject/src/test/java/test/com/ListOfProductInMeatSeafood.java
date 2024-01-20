/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import com.mycompany.costcoproject.FileUtil;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class ListOfProductInMeatSeafood {

    private WebDriver driver;
    private String baseUrl;

    public ListOfProductInMeatSeafood() {
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
        driver.get("https://www.costco.com/meat.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @Test
    public void testAddToListButton() throws Exception {
        
        driver.findElement(By.xpath("//div[@id='productTile_4000149679']/div[2]/div[2]/div/div/div/div/div/button/span")).click();
        driver.get("https://signin.costco.com/e0714dd4-784d-46d6-a278-3e29553483eb/B2C_1A_SSO_WCS_signup_signin_567/oauth2/v2.0/authorize?ClientName=USBC&ui_locales=en-US&scope=openid+offline_access&response_type=code+id_token&redirect_uri=https%3A%2F%2Fwww.costco.com%2FOAuthLogonCmd&state=URL%3D%5BSSO%5Dhttps%3A%2F%2Fwww.costco.com%2Fmeat.html%5BSSO%5D&nonce=wlBg7V6jWHTTqAIO&client_id=4900eb1f-0c10-4bd9-99c3-c59e6c1ecebf&TC=0&response_mode=form_post");
        assertEquals(driver.getTitle(), "Sign In");
    }
    
    @Test
    public void testSelectingItem() throws Exception {
   
        driver.findElement(By.linkText("Crescent Foods Halal Hand-Cut Beef, Chicken Combo Pack - 14 Total Packs, 13.5 Lbs. Total")).click();
        driver.get("https://www.costco.com/crescent-foods-halal-hand-cut-beef%2c-chicken-combo-pack---14-total-packs%2c-13.5-lbs.-total.product.4000149679.html");
        assertEquals(driver.findElement(By.id("product-details")).getText().contains("Crescent Foods Halal Hand-Cut Beef, Chicken Combo Pack - 14 Total Packs, 13.5 Lbs. Total"), true);
    }
    
//    @Test
//    public void testProductInfor() throws Exception {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1500)", "");
//        
//        WebDriverWait wait1 =new WebDriverWait(driver, 30);
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"productTile_100421889\"]/div[2]/div[2]/span/a")));
//        String actual = driver.findElement(By.xpath("//*[@id=\"productTile_100421889\"]/div[2]/div[2]/span/a")).getText();
//        assertEquals(actual, FileUtil.getData().name);
//        
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("price-1260562")));
//        String actualPrice = driver.findElement(By.id("price-1260562")).getText();
//        assertEquals(actual, FileUtil.getData().price);
//    }
}
