import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest2 extends WebTest1{

    @Test
    public void testTwo () throws InterruptedException {
//        String driverPathChrome = "D:\\chromedriver_win32/chromedriver.exe";
//        String chromeDriver = "webdriver.chrome.driver";
//        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";
//        System.setProperty(chromeDriver, driverPathChrome);
        // Создаем драйвер, чтобы он начал выполнять действия
//        WebDriver driver = new ChromeDriver();git

        // Открываем страницу http
        driver.get(url);
        // Выставляем задержку в 3 сек
        Thread.sleep(3000);
        // Находим заголовок, который будет являться результатом теста
        WebElement actualResult = driver.findElement(By.xpath("//div[@id='main']//h2[text()='Welcome to 99 Bottles of Beer']"));
        // Сравниваем - достаем с заголовка текс и сравниваем его с expectedResult.
        Assert.assertEquals(actualResult.getText(), "Welcome to 99 Bottles of Beer");
    }
}
