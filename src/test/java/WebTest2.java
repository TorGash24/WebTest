import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTest2 extends SettingDriver{


    @Test
    public void testGuestBook () {
        String expectedResult1 = "http://www.99-bottles-of-beer.net/search.html";
        driver.get(url);
        driver.findElement(By.xpath("//ul[@id='menu']//a[text()='Search Languages']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Java");
        List<WebElement> itemList = driver.findElements(By.xpath("//table[@id='category']//td[@bgcolor='#efefef']/a"));
        for (int i =0; i <itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }
        System.out.println(itemList.get(1));




    }
}
