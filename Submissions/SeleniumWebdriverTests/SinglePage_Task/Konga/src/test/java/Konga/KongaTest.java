package Konga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KongaTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty ("webdriver.chrome.driver","resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get ("https://www.konga.com/");
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        //Get page title
        System.out.println(driver.getTitle ());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testNegativeLogin() throws InterruptedException{
        //click on login/signup button
        driver.findElement(By.linkText("Login / Signup")).click();

        //Enter username
        driver.findElement(By.id("username")).sendKeys("email/phone number");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("Password");

        //Click on Login
        driver.findElement(By.xpath("//button[text() = 'Login']")).click();

        //Wait, so the next operation won't happen so fast
        Thread.sleep(5000);

        //click Computers and Accessories Category
        driver.findElement(By.className("ef511_2c5_i")).click();
        Thread.sleep(5000);

        //click laptops
        driver.findElement(By.linkText("Laptops")).click();
//        actions.click(Laptops).perform();
        Thread.sleep(5000);

        //Click on the Laptops subcategory
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a")).click();
        Thread.sleep(5000);

        //Click on the Apple MacBooks button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);

        //Click on the Add to cart button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[10]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(5000);

        //Click on the My Cart menu button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //Click on Checkout
        driver.findElement(By.className("_0a08a_3czMG")).click();
        Thread.sleep(5000);

        //Click to Select Delivery Address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div/a")).click();
        Thread.sleep(5000);

        //Click to Address Book
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);

        //Click to Use this Address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //Select the PayNow
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[4]/form/ul/li/div/button")).click();
        Thread.sleep(5000);

        //Click on the Continue to Payment button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[9]/div/button")).click();
        Thread.sleep(5000);

        //Select iframe that comes up for payment
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(5000);

        //Click on the card option
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //Enter the card number
        driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("5399000000000002");

        //Enter Expiry Date
        driver.findElement(By.xpath("//*[@id=\"expiry\"]")).sendKeys("0530");

        //Enter CVV
        driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("000");

        //Click on the Pin input box
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();

        //Enter Pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[11]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[11]")).click();

        //Select the PAY NOW Option
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);

        String expectedErrorMessage = "Invalid card number";
//        String actualErrorMessage = driver.findElement(By.id("//*[@id=\"card-number_unhappy\"]")).getText();
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("Failed - The user was unable to login");
        }else {
            System.out.println("PASSED - User has successfully logged in");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
