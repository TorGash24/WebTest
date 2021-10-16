import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SettingDriver {

    protected WebDriver driver;
    protected String url = "http://www.99-bottles-of-beer.net/";

    @BeforeMethod
    public void createChromeDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterTest
    public void afterTest () {
        driver.close();
        driver.quit();
    }


}
