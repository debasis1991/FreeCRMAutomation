package com.qa.JawwyAE.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    Properties prop;


    public WebDriver init_driver(Properties prop) {
        String browserName = this.prop.getProperty("browser");
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/debasisrout/Documents/Driver/chromedriver");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/debasisrout/Documents/Driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(this.prop.getProperty("url"));
        //driver.get("https://10.27.129.91");
        return driver;
    }

    public Properties init_prop() {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream("/Users/debasisrout/Documents/Automation/src/main/java/com/qa/JawwyAE/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
