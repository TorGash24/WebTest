package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod () {
        driver.close();
        driver.quit();
    }

    @Test
    public void signUp() {

        // Устанавливаем размер страницы браузера
        driver.manage().window().maximize();
        // Делаем задержку в 10сек, если элемент найден переходи к следующей строке
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Задаем адрес страницы
        driver.get("https://www.drom.ru/");

        WebElement signUp= driver.findElement(By.xpath("//div[@class='css-16566ot e173iafn0']"));
        signUp.findElement(By.xpath("//a[@class='css-1wj52qf e1k6fwrt0']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumbs")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signbutton")));
        // генерируем случайное число и записываем в переменную
//        Random random = new Random();
//        int n = random.nextInt(100) + 1;
        // генерируем случайный email
        String email = "anton15440"; // + n + "@mail.ru";
        System.out.println(email);
        // вводим email
        driver.findElement(By.xpath("//div[@class='controlBody']//input[@name=\"sign\"]")).sendKeys(email);
        // создаем password
        String password = "123456789";
        System.out.println(password);
        // вводим password
        driver.findElement(By.id("password")).sendKeys(password);
        // кликаем регистрация
        driver.findElement(By.id("signbutton")).click();

        // проверяем на появление ошибки
        WebElement error = driver.findElement(By.xpath("//div[text()='Данные для входа неверны']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Данные для входа неверны']")));

        // Закрываем браузер после теста
        driver.quit();
    }
}
