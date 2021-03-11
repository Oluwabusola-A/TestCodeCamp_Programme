package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty ("webdriver.chrome.driver","resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get ("https://web.facebook.com/");
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        //Get page title
        System.out.println(driver.getTitle ());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        //Click on the email field and input a valid email
        driver.findElement(By.id("email")).sendKeys("aiyegbusioluwabusola@yahoo.com");
        //Click on the password field and input a valid password
        driver.findElement(By.id("pass")).sendKeys("Busola@3");
        //click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("Failed - The user was unable to login");
        }else {
            System.out.println("PASSED - User has successfully logged in");
        }
        Thread.sleep(5000);
    }

    @Test
    public void logoutTest() throws InterruptedException {
        //Click on the user profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]")).click();
        if (driver.getCurrentUrl().contains("https://web.facebook.com/?_rdc=1&_rdr")) {
            System.out.println("Failed - The user is still logged in");
        } else {
            System.out.println("PASSED - User has successfully logged out");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
