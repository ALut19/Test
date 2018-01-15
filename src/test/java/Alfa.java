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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;
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

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='text']"));

        searchBox.sendKeys("Альфа Банк");
        searchBox.submit();

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        WebElement alfaHref = driver.findElement(By.xpath("//a/b[text()='AlfaBank.ru']"));
        alfaHref.click();

        Set<String> wn = driver.getWindowHandles();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Работайте у нас']")));
        driver.findElement(By.xpath("//a[text()='Работайте у нас']")).click();

        }
    }