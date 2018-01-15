import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 15.01.2018.
 */
public class Sber_Task_1 {

    @Test
    public void main () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:/drv/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 1. Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get("http://www.sberbank.ru/ru/person");

        // 2. Нажать на – Застраховать себя и имущество
        Thread.sleep(5000);
        WebElement insuranse = driver.findElement(By.xpath("//a[@aria-label='Раздел Застраховать себя  и имущество']"));
        insuranse.click();
        Thread.sleep(7000);
        insuranse.click();

        // 3. Выбрать – Страхование путешественников
        WebElement insuranseTravel = driver.findElement(By.xpath("//a[@href='/ru/person/bank_inshure/insuranceprogram/life/travel']"));
        System.out.println("Травел");
        insuranseTravel.click();
        System.out.println("Травел-клик");

        // 4. Проверить наличие на странице заголовка – Страхование путешественников

        // 5. Нажать на – Оформить Онлайн
         WebElement onlineIssue = driver.findElement(By.xpath("//img[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", onlineIssue);
        System.out.println("Онлайн");
        onlineIssue.click();

        // Переход на новую вкладку
        Set<String> wh = driver.getWindowHandles();
        List<String> whl=new ArrayList<>(wh);
        driver.switchTo().window(whl.get(1));

        // 6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        WebElement minInsurance = driver.findElement(By.xpath("//div[text()='Минимальная']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", minInsurance);
        System.out.println("Минимальная");
        minInsurance.click();

        // 7. Нажать Оформить
        WebElement contin = driver.findElement(By.xpath("//span[@class='b-continue-btn']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", contin);
        System.out.println("Оформить");
        contin.click();

        //8. На вкладке Оформить заполнить поля:
        // - Фамилию и Имя, Дату рождения застрахованных
        WebElement surnameEng = driver.findElement(By.xpath("//input[@ng-model='namespace.SURNAME_ENG']"));
        surnameEng.sendKeys("IVANOV");
        WebElement nameEng = driver.findElement(By.xpath("//input[@ng-model='namespace.NAME_ENG']"));
        nameEng.sendKeys("IVAN");
        WebElement birthdate = driver.findElement(By.xpath("//input[@ng-model='namespace.BIRTHDATE']"));
        birthdate.sendKeys("10101980");

        // - Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        WebElement issuerSurname = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.LASTNAME']"));
        issuerSurname.sendKeys("Петров");
        WebElement issuerFirstname = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.FIRSTNAME']"));
        issuerFirstname.sendKeys("Петр");
        WebElement issuerMiddlename = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.MIDDLENAME']"));
        issuerMiddlename.sendKeys("Петрович");
        WebElement birthdate2 = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.BIRTHDATE']"));
        birthdate2.sendKeys("01011991");

        // - Паспортные данные
        WebElement serDoc = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.documentList[0].DOCSERIES']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", serDoc);
        serDoc.sendKeys("1359");
        WebElement numDoc = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']"));
        numDoc.sendKeys("123579");
        WebElement actDocDate = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']"));
        actDocDate.sendKeys("02102008");
        WebElement issuedDoc = driver.findElement(By.xpath("//input[@ng-model='formdata.insurer.documentList[0].ISSUEDBY']"));
        issuedDoc.sendKeys("ОВД г. Тамбов");


        // 9. Проверить, что все поля заполнены правильно

        // 10. Нажать продолжить
        WebElement contin2 = driver.findElement(By.xpath("//span[@class='b-continue-btn']"));
        contin2.click();







    }
}
