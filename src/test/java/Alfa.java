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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 27.06.2017.
 */
public class Alfa {

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "c:/drv/chromedriver.exe");

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

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> wh = driver.getWindowHandles();
        List<String> whl=new ArrayList<>(wh);

        driver.switchTo().window(whl.get(1));

        WebDriverWait wait = new WebDriverWait(driver, 30);

             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Работайте у нас']"))));

            WebElement foo = driver.findElement(By.xpath("//div[@class='footer__navigation']"));//.click();
            if (foo != null)
                driver.findElement(By.xpath("//a[text()='Работайте у нас']")).click();

            // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://job.alfabank.ru/']")));
            //  driver.findElement(By.xpath("//a[@href='http://job.alfabank.ru/']")).click();


            //  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", job);
            //  ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
            // job.click();
        driver.quit();
        }
        }
