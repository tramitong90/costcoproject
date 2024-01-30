package test.com;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 * @author navat
 */
public class SigninTest {

    private WebDriver driver;
    private String baseUrl;

    public SigninTest() {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        //driver.quit();
    }

    @Test
    public void TestSignin() throws Exception {
        driver.get("https://www.costco.com");
        WebDriverWait wait0 = new WebDriverWait(driver, 10);  //20 sec
        wait0.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_sign_in")));
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("signInName")).click();
        driver.findElement(By.id("signInName")).sendKeys(FileUtil.ReadLogin().getUsername());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(FileUtil.ReadLogin().getPassword());
        WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
        WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("next")));
        el.click();
    }
}
