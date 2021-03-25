package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    private WebDriver driver;
    private By selectAddress = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a");
    private By payNowButton = By.xpath("//button[@data-payment-method='kpaygateway']");
    private By continueToPaymentButton = By.xpath("//button[@value='kpaygateway']");
    private By checkOut_iFrame = By.xpath("//*[@id='kpg-frame-component']");
    private By cardButton = By.cssSelector(".Card");
    private By cardNumberField = By.xpath("//*[@id='card-number']");
    private By dateField = By.id("expiry");
    private By cvvField = By.id("cvv");
    private By invalidMessage = By.xpath("//*[@id='card-number_unhappy']");
    public CheckOutPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickOnPayNow()
    {
        driver.findElement(payNowButton).click();
    }
    public void clickContinueToPayment() throws InterruptedException
    {
        driver.findElements(continueToPaymentButton).get(1).click();
        Thread.sleep(10000);
    }
    //Choose the Payment Type
    public void clickOnPaymentType() throws InterruptedException
    {
        WebElement checkOutFrame = driver.findElement(checkOut_iFrame);
        //Switch to iFrame
        driver.switchTo().frame(checkOutFrame);
        driver.findElement(cardButton).click();
        Thread.sleep(3000);
    }
    //Input card details
    public void enterCardDetails(String cardNumber, String date, String cvv)
    {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(cvvField).sendKeys(cvv);
    }
    //Return User invalid message
    public String invalid_message()
    {
        return driver.findElement(invalidMessage).getText();
    }
}