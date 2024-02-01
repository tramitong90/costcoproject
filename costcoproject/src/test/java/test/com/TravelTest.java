/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import com.mycompany.costcoproject.FileUtil1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
public class TravelTest {

    private WebDriver driver;
    private String baseUrl;

    public TravelTest() {
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
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.costcotravel.com/");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @Test
    public void testWidget() throws Exception {

        WebElement element = driver.findElement(By.id("hotels-tab-id"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement element1 = driver.findElement(By.id("hotelDestination"));
        js.executeScript("arguments[0].click();", element1);

        // driver.findElement(By.xpath("//div[@id='hotel_destination_widget']/div/ul/li")).click();
        driver.findElement(By.id("hotelDestination")).clear();
        driver.findElement(By.id("hotelDestination")).sendKeys(FileUtil1.getData().destination);
        driver.findElement(By.id("checkInDateWidget")).click();
        driver.findElement(By.id("checkInDateWidget")).clear();
        driver.findElement(By.id("checkInDateWidget")).sendKeys(FileUtil1.getData().getCheckIn());
        driver.findElement(By.id("checkOutDateWidget")).click();
        driver.findElement(By.id("checkOutDateWidget")).clear();
        driver.findElement(By.id("checkOutDateWidget")).sendKeys(FileUtil1.getData().getCheckOut());
        
        WebElement element2 = driver.findElement(By.id("hotelAdultsInRoomForWidget_1"));
        js.executeScript("arguments[0].click();", element2);
        driver.findElement(By.xpath("//*[@id=\"hotelAdultsInRoomForWidget_1\"]/option[4]")).click();
        //new Select(element2).selectByValue(FileUtil1.getData().numOfAdult);
        
        WebElement element4 = driver.findElement(By.id("hotelChildrenInRoomForWidget_1"));
        js.executeScript("arguments[0].click();", element4);
        driver.findElement(By.xpath("//*[@id=\"hotelChildrenInRoomForWidget_1\"]/option[4]")).click();
        //new Select(element4).selectByValue(FileUtil1.getData().numOfChild);
        
        new Select(driver.findElement(By.id("hotelChildAgeForWidget_1_1"))).selectByVisibleText(FileUtil1.getData().ageOfChild1);
        driver.findElement(By.id("hotelChildAgeForWidget_1_2")).click();
        new Select(driver.findElement(By.id("hotelChildAgeForWidget_1_2"))).selectByVisibleText(FileUtil1.getData().ageOfChild2);
        driver.findElement(By.id("hotelChildAgeForWidget_1_3")).click();
        new Select(driver.findElement(By.id("hotelChildAgeForWidget_1_3"))).selectByVisibleText(FileUtil1.getData().ageOfChild3);
        driver.findElement(By.xpath("//div[@id='ageAndSubmitDiv']/div[2]/button")).click();

        WebElement element3 = driver.findElement(By.cssSelector("img[alt='Screen is Loading']"));
        js.executeScript("arguments[0].click()", element3);
        assertEquals(element3.isEnabled(), true);
    }
    
}
