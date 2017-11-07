import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // driver.get("https://alfabank.ru/");
         driver.get("https://yandex.ru");

      //  driver.manage().window().maximize();
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='text']"));

            searchBox.sendKeys("Альфа Банк");
            searchBox.submit();
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        WebElement alfaHref = driver.findElement(By.xpath("//a/b[text()='AlfaBank.ru']"));
            alfaHref.click();


            WebDriverWait wait = new WebDriverWait(driver, 45);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Работайте у нас']")));
        driver.findElement(By.xpath("//a[text()='Работайте у нас']")).click();

           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://job.alfabank.ru/']")));
          //  driver.findElement(By.xpath("//a[@href='http://job.alfabank.ru/']")).click();


          //  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", job);
          //  ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
           // job.click();

        }
    }