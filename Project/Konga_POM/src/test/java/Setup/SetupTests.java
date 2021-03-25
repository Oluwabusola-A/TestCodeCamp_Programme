package Setup;
import Welcome.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupTest {
    private WebDriver driver;
    public WelcomePage welcomePage;

    //Initialize WebDriver, lunch the browser  and go to the URL before carrying on the test
    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\student114\\TestCodeCamp_Programme\\Submissions\\KongaProject\\resources\\chromedriver.exe");
        //Initializing WebDriver
        driver = new ChromeDriver();

        //Maximize web browser
        driver.manage().window().maximize();
        //Open URL on browser
        driver.get("https://www.konga.com/");
        welcomePage = new WelcomePage(driver);
    }

    //Close WebDriver and browser when test is completed
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}