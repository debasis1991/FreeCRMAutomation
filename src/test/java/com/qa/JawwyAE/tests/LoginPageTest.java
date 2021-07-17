package com.qa.JawwyAE.tests;
import org.testng.TestNG;
import com.qa.JawwyAE.base.BasePage;
import com.qa.JawwyAE.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
WebDriver driver;
BasePage basepage;
LoginPage loginpage;
Properties prop;

@BeforeTest
    public void setup(){
        basepage = new BasePage();
        prop = basepage.init_prop();
        driver = basepage.init_driver(prop);
        loginpage = new LoginPage(driver);

    }

    @Test (priority = 1)
    public void verifyloginlink(){
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Assert.assertTrue(loginpage.verifyloginlink(), "Sign Up Link not displayed");
    }

    @Test (priority = 2)
    public void doLogin() throws InterruptedException {

        loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password") );
    }


@AfterTest
public void teardown(){
  driver.quit();
 }
}
