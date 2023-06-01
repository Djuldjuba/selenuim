import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class FirstTest {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        //Шаг 1-3 Открыть страницу и авторизоваться
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Taraskina Valeriya");
        driver.findElement((By.xpath("//input[@name='_password']"))).sendKeys("testing");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        WebElement fastPanel = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        wait.until(ExpectedConditions.visibilityOf(fastPanel));
        Assertions.assertEquals("Панель быстрого запуска", fastPanel.getText(),
                "панель быстрого запуска не отображается");

        // Шаг 4 Перейти в командировки
        driver.findElement(By.xpath("//span[.='Расходы']")).click();
        WebElement businessTrip = driver.findElement(By.xpath("//span[.='Командировки']"));
        wait.until(ExpectedConditions.visibilityOf(businessTrip));
        businessTrip.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.
                xpath("//div[@class='loader-frame well']"))));

        //Шаг 5-6 Перейти на страницу "Создать командировку" и проверить наличие заголовка
        driver.findElement(By.xpath("//a[.='Создать командировку']")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.
                xpath("//div[@class='loader-frame well']"))));
        WebElement header = driver.findElement(By.xpath("//h1[.='Создать командировку']"));
        Assertions.assertEquals(header.getText(), "Создать командировку");

        //Шаг 7 Заполнение и выбор полей
        Select subdivision = new Select(driver.findElement(By.name("crm_business_trip[businessUnit]")));
        subdivision.selectByVisibleText("Бухгалтерия");

        WebElement checkbox1 = driver.findElement(By.xpath("//a[@id='company-selector-show']"));
        checkbox1.click();

        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='select2-results']"))));
        driver.findElement(By.xpath("//div[.='(Safari) Призрачная Организация Охотников']")).click();

        driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();

        WebElement cityFrom = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
        cityFrom.clear();
        cityFrom.sendKeys("Нижний Новгород");
        WebElement cityTo = driver.findElement(By.xpath("//input[@data-name='field__arrival-city']"));
        cityTo.sendKeys("Москва");

        WebElement timeOut = driver.findElement(By.cssSelector(".control-group-date:nth-of-type(1) .datepicker-input"));
        timeOut.sendKeys("01.09.2023");
        WebElement timeIn = driver.findElement(By.cssSelector(".control-group-date:nth-of-type(2) .datepicker-input"));
        timeIn.sendKeys("01.10.2023");
        timeIn.sendKeys(Keys.ESCAPE);

        //Шаг 8 Проверка, что поля заполнены правильно

        Assertions.assertEquals("Бухгалтерия", subdivision.getFirstSelectedOption().getText(),
                "подразделение заполнено неверно");

        Assertions.assertEquals("(Safari) Призрачная Организация Охотников",
                driver.findElement(By.xpath("//span[@class='select2-chosen']")).getText(),
                "отображается наверная организация");

        Assertions.assertEquals("Нижний Новгород", cityFrom.getAttribute("value"),
                "город отбытия указан неверно");
        Assertions.assertEquals("Москва", cityTo.getAttribute("value"),
                "Город прибытия указан неверно");

        Assertions.assertEquals("01.09.2023", timeOut.getAttribute("value"),
                "неверная дата выезда");
        Assertions.assertEquals("01.10.2023", timeIn.getAttribute("value"),
                "неверная дата заезда");

        //Шаг 9 Нажать "сохранить и выйти"
        driver.findElement(By.cssSelector(".action-button:not(.main-group)")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@class='loader-frame well']"))));

        //Шаг 10 Проверить, что на странице появилось сообщение "Список командируемых сотрудников не может быть пустым"
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",
                driver.findElement(By.xpath("//span[.='Командированные сотрудники']/../..//span[@class='validation-failed']")).getText(),
                "сообщение об ошибке не появилось");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}
