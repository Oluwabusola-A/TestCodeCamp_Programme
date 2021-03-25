package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By nameOfUser = By.id("username");
    private By passwordOfUser = By.id("password");
    private By loginButton = By.xpath("//button[@class='_0a08a_3czMG _988cf_1aDdJ']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Enter Username
    public void enterUsername(String hostName)
    {
        driver.findElement(nameOfUser).sendKeys(hostName);
    }

    //Enter Password
    public void enterPassword(String hostPassword)
    {
        driver.findElement(passwordOfUser).sendKeys(hostPassword);
    }

    //Click on the Login button
    public WelcomePage clickLoginButton() throws InterruptedException
    {
        driver.findElement(loginButton).click();
        Thread.sleep(3000);
        return new WelcomePage(driver);
    }

}