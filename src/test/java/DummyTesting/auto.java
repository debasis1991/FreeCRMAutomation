package DummyTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class auto {

    public static void main(String[] args) throws InterruptedException {
        By login = By.id("button-1031-btnInnerEl");
        By username = By.id("textfield-1043-inputEl");
        By password = By.id("textfield-1044-inputEl");
        By plm = By.xpath("//*[text()='PLM']");
        System.setProperty("webdriver.gecko.driver", "/Users/debasisrout/Documents/Driver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(driver,200);
        driver.manage().window().maximize();
        driver.get("https://10.27.129.91");
        wait.until(ExpectedConditions.elementToBeClickable(username));
        System.out.println("Current title is : " + driver.getTitle());
        driver.findElement(username).sendKeys("dorout");
        wait.until(ExpectedConditions.elementToBeClickable(password));
        Thread.sleep(3000);
        driver.findElement(password).sendKeys("Telkom@12345");
        wait.until(ExpectedConditions.elementToBeClickable(login));
        Thread.sleep(3000);
        driver.findElement(login).click();
        wait.until(ExpectedConditions.elementToBeClickable(plm));
        Thread.sleep(3000);
        driver.findElement(plm).click();

    }
}