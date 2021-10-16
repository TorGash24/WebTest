import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest1 extends SettingDriver{

    @Test
    public void testFirst() throws InterruptedException {
        String expectedResult = "http://www.99-bottles-of-beer.net/";
        driver.get(url);
        Thread.sleep(3000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testTwo () throws InterruptedException {

        String expectedResult = "Welcome to 99 Bottles of Beer";
        driver.get(url);
        Thread.sleep(3000);
        WebElement actualResult = driver.findElement(By.xpath("//div[@id='main']//h2[text()='Welcome to 99 Bottles of Beer']"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Test
    public void testThree () throws InterruptedException {

        String expectedResult = "Error:";
        driver.get(url);
        Thread.sleep(3000);
        WebElement SubmitNewLanguage = driver.findElement(By.linkText("Submit new Language"));
        SubmitNewLanguage.click();
        driver.findElement(By.xpath("//form[@id='addlanguage']/p/input[@name='language']")).sendKeys("English");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@name='category']")).click();
        driver.findElement(By.xpath("//select[@name='category']/option[@value][3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@name='code']")).sendKeys("IMPORTANT: Take your time! The more carefully " +
                "you fill out this form (especially the language name and description), the easier it will be for " +
                "us and the faster your language will show up on this page. We don't have the time to mess around " +
                "with fixing your descriptions etc. Thanks for your understanding.\n");
        driver.findElement(By.linkText("Top Lists")).click();
        driver.findElement(By.linkText("Malbolge (real loop version)")).click();
        driver.findElement(By.xpath("//select[@name='rate']")).click();
        driver.findElement(By.xpath("//select[@name='rate']/option[6]")).click();
        driver.findElement(By.xpath("//div[@id='voting']//input[@name='submitcomment'][@class='button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[text()= 'Error:']")).getText(), expectedResult);


    }

}
