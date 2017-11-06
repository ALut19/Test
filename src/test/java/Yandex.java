import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by user on 27.06.2017.
 */
public class Yandex {

    @Test
    public void vasya124()
    {
        System.setProperty ("webdriver.chrome.driver","C:/Java/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driverc = new ChromeDriver();
        driverc.get("http://www.ya.ru");
        try {
            Thread.sleep(5000);  // Let the user actually see something!

            WebElement searchBox = driverc.findElement(By.xpath("//input[@class=\"input__control input__input\"]"));
            searchBox.sendKeys("ChromeDriver");
            searchBox.submit();
            Thread.sleep(15000);  // Let the user actually see something!
            driverc.quit();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
         /*   WebElement electonic1 = driverc.findElement(By.xpath("/div/button[@class='button button_size_m button_theme_normal button_arrow_down i-bem button_js_inited _popup2-destructor _popup2-destructor_js_inited n-topmenu-new-vertical__popup-show']")); */

       /*    Assert.assertTrue("ываы", driverc.findElement(By.xpath("//div/ul/li[ @class='n-breadcrumbs__item n-breadcrumbs__item_type_text']")).isDisplayed());
            driverc.quit()*/