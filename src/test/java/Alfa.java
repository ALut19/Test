import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 27.06.2017.
 */
public class Alfa {

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "C:/Java/driver/chromedriver_win32/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        //driver.get("https://alfabank.ru/");
          driver.get("https://yandex.ru");
        try {
            Thread.sleep(7000);
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='text']"));

            searchBox.sendKeys("Альфа Банк");
            searchBox.submit();

            Thread.sleep(5000);
            WebElement alfaHref = driver.findElement(By.xpath("html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul/li[3]/div/div[1]/div[1]/a/b"));
            alfaHref.click();

            Thread.sleep(15000);  // Let the user actually see something!
          /*  WebElement busines = driver.findElement(By.xpath(".//*[@id='home_page']/div[1]/div[5]/div/ul/li[2]"));
            busines.click();*/


      //   WebElement job = driver.findElement(By.xpath("//*[@id='home_page']/div[1]/div[6]/div/div/div[1]/div[3]/ul/li[3]/a"));
            WebElement job = driver.findElement(By.xpath("//div/../a[contains(text(), 'Работайте у нас')]"));

          //  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", job);
          //  ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
            job.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}