package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignIn {
    // import the selenium WebDriver
    private WebDriver driver;

    //functions before test commence
    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //lunch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website url
        driver.get ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        //wait for the page to load in 5 seconds
        Thread.sleep (5000);
        //Maximize the browser
        driver.manage().window().maximize();
        //Get page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        //Click on the username field and input a valid username "performancetest"
        driver.findElement(By.id("username")).sendKeys("performancetest");
        //locate the email field and use your own valid password "admin123."
        driver.findElement(By.id("password")).sendKeys("admin123.");
        //Click on the login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        //wait to see users logged in page
        Thread.sleep(5000);
        //Test to confirm user logged in
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")){
            System.out.println("PASSED-User has successfully logged in'");
        }else{
            System.out.println("Failed-User was unable to login");
        }
        Thread.sleep(5000);
        //waiting to see logged in page
    }
    @Test
    public void logoutTest() throws InterruptedException {
        //click on the user profile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep (5000);
        //click on the login button
        driver.findElement (By.linkText ("Log Out")).click ();
        //Test to confirm user logged out
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println("PASSED-User has successfully logged out");
        }else{
            System.out.println("Failed-User is still logged in");
        }
        Thread.sleep(5000);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
