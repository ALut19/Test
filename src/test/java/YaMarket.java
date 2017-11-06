import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 27.06.2017.
 */
public class YaMarket {

    @Test
    public void main()
    {
        System.setProperty ("webdriver.chrome.driver","C:/Java/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driverc = new ChromeDriver();
        driverc.get("https://market.yandex.ru/");
        try {
            Thread.sleep(7000);  // Let the user actually see something!


            WebElement region = driverc.findElement(By.xpath("//div[@class='n-region-notification b-zone i-bem n-region-notification_js_inited']"));
            WebElement yesButton = driverc.findElement(By.xpath("//div/span[contains(@class,'button2')]"));
            yesButton.click();

            WebElement electronic = driverc.findElement(By.xpath("//div/../a[contains(text(), 'Электроника')]"));
            electronic.click();
            Thread.sleep(5000);  // Let the user actually see something!

            WebElement mobile = driverc.findElement(By.xpath("//div/../a[contains(text(), 'Мобильные телефоны')]"));
            mobile.click();
            Thread.sleep(5000);
//('//div/../a[contains(text(), "Мобильные телефоны")]')

            WebElement samsung = driverc.findElement(By.xpath("//div[contains(@title, 'Мобильные телефоны Samsung')]"));
            samsung.click();
            Thread.sleep(5000);

            WebElement pricefrom = driverc.findElement(By.xpath("//input[contains(@name, 'glf-pricefrom-var')]"));
            pricefrom.sendKeys("40000");
            Thread.sleep(5000);

            WebElement phone1 = driverc.findElement(By.xpath("//div/a[contains(@class,'link n-link_theme_blue')]"));
            phone1.getText();
            String flag1 = phone1.getText();

            System.out.println(flag1);
        //    ((JavascriptExecutor)driverc).executeScript("arguments[0].scrollIntoView();",searchFirstPositionOfPhone1);
           phone1.click();
            Thread.sleep(10000);

            WebElement phoneSamsung = driverc.findElement(By.xpath("//div/h1[contains(@class,'title title_size_28 title_bold_yes')]"));
            phoneSamsung.getText();
            String flag2 = phoneSamsung.getText();

            System.out.println(flag2);

            Assert.assertTrue(flag1.equals(flag2));
            //Assert.assertSame(phone1.getText(),phoneSamsung.getText());
            System.out.println("ok");

 //       Assert.assertTrue("ываы", driverc.findElement(By.xpath("//div/ul/li[ @class='n-breadcrumbs__item n-breadcrumbs__item_type_text']")).isDisplayed());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
