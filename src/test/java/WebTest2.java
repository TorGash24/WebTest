import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest2 extends WebTest1{

    @Test
    public void testTwo () throws InterruptedException {

        String expectedResult = "Welcome to 99 Bottles of Beer";
        driver.get(url);
        Thread.sleep(3000);
        WebElement actualResult = driver.findElement(By.xpath("//div[@id='main']//h2[text()='Welcome to 99 Bottles of Beer']"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
}
