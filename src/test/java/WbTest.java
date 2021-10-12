import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WbTest {
    public WebDriver driver;
    public String url = "http://www.99-bottles-of-beer.net/";
    public String driverPathChrome = "D:\\chromedriver_win32/chromedriver.exe";
    public String chromeDriver = "webdriver.chrome.driver";

    // выполняется каждый раз перед тестом.
    @BeforeTest
    public void beforeTest () {
        System.setProperty(chromeDriver, driverPathChrome);
        driver = new ChromeDriver();

    }
    // выполняется каждый раз после тестов
    @AfterTest
    public void afterTest () {
        driver.close();
        driver.quit();
    }

    @Test
    public void testFirst() throws InterruptedException {
                          // ПЕРВАЯ ЧАСТЬ
        // Путь к папке с файлом chromedriver
//        String driverPathChrome = "D:\\chromedriver_win32/chromedriver.exe";
//        String chromeDriver = "webdriver.chrome.driver";
//        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "http://www.99-bottles-of-beer.net/";


                         // ВТОРАЯ ЧАСТЬ
        //System.setProperty(chromeDriver, driverPathChrome);
        // Создаем драйвер, чтобы он начал выполнять действия
        //WebDriver driver = new ChromeDriver();

        // Открываем страницу http
        driver.get(url);
        // Выставляем задержку в 3 сек
        Thread.sleep(3000);
        // Прописываем actualResult - драйвер считает url со страницы
        String actualResult = driver.getCurrentUrl();


                        // Третья ЧАСТЬ
        Assert.assertEquals(actualResult, expectedResult);




    }
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
        System.out.println(url);


    }
}
