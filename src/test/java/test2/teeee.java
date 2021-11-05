package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class teeee {
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
    public void openSite () {
                driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = "https://www.loadview-testing.com/";
        String expectedResult = "https://www.loadview-testing.com/";

        driver.get(url);
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    @Test
    public void getStartedFree () {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "https://www.loadview-testing.com/";
        driver.get(url);
        String expectedResult1 = "https://userauth.dotcom-monitor.com/Account/LoadView-FreeTrialSignUp";
        String expectedResult2 = "Start Your Free SaaS Trial";

        WebElement startFreeTrial = driver.findElement(By.xpath("//div[@id='et-main-area']//a[text()='Start Free Trial']"));
        startFreeTrial.click();
        String actualResult1 = driver.getCurrentUrl();

        Assert.assertEquals(expectedResult1, actualResult1);

        WebElement actualresulr2 = driver.findElement(By.xpath("//span[@class='dcm-authorization__title']"));
        ;
        Assert.assertEquals(actualresulr2.getText(), expectedResult2);

        driver.quit();
    }
    @Test
    public void inputEmail () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "https://userauth.dotcom-monitor.com/Account/LoadView-FreeTrialSignUp";
        String expectedResult = "Business email address is required. Using free email services are not allowed.";
        driver.get(url);

        WebElement enterYourWorkEmail = driver.findElement(By.xpath("//input[@id='Contact_Email_Addr']"));
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String email = "antonwork" + n + "@gmail.com";
        System.out.println(email);
        enterYourWorkEmail.sendKeys(email);
        WebElement button = driver.findElement(By.xpath("//div[@id='dcmAuthorizationButton']//button"));
        button.click();
        Thread.sleep(3000);
        WebElement errorInputEmail = driver.findElement(By.xpath("//div[@class='dcm-authorization-grid']//span[@class='field-validation-error']"));
        Assert.assertEquals(errorInputEmail.getText(), expectedResult);
        driver.quit();
    }
    @Test
    public void enterpriseSignUp () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "https://www.loadview-testing.com/";
        String expectedResult = "Thank you for your message. It has been sent.";
        driver.get(url);
        WebElement enterpriseButton = driver.findElement(By.xpath("//ul[@id='top-menu']//li[@id='menu-item-665']"));
        enterpriseButton.click();
        WebElement yourName = driver.findElement(By.xpath("//input[@name='your-name']"));
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String name = "antonG" + n + "@yandex.ru";
        System.out.println(name);
        yourName.sendKeys(name);
        WebElement companyName = driver.findElement(By.xpath("//input[@name='company-name']"));
        String nameCompany = "Wisco" + n + "corporation";
        companyName.sendKeys(nameCompany);
        WebElement yourWebsite= driver.findElement(By.xpath("//input[@name='your-website']"));
        yourWebsite.sendKeys("https://www.zeladmin.ru/");
        WebElement estimatedWebsiteTrafficSelect = driver.findElement(By.xpath("//option[@value='100K - 300K visits per month']"));
        estimatedWebsiteTrafficSelect.click();
        WebElement yourPhone= driver.findElement(By.xpath("//input[@name='your-phone']"));
        yourPhone.sendKeys("8-800-200-6000");
        WebElement yourEmail = driver.findElement(By.xpath("//input[@name='your-email']"));
        yourEmail.sendKeys("Anton@mail.ru");
        WebElement yourMessage= driver.findElement(By.xpath("//textarea[@name='your-message']"));
        yourMessage.sendKeys("Hello my friends");

        WebElement submit= driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(3000);
        WebElement signUpAdd = driver.findElement(By.xpath("//div[@class='wpcf7-response-output']"));
        Assert.assertEquals(signUpAdd.getText(), expectedResult);
        driver.quit();
    }
}
