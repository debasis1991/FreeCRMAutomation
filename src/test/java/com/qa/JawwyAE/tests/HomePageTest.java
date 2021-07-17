package com.qa.JawwyAE.tests;
import com.qa.JawwyAE.base.BasePage;
import com.qa.JawwyAE.pages.HomePage;
import com.qa.JawwyAE.pages.LoginPage;
import com.qa.JawwyAE.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {

        WebDriver driver;
        BasePage basepage;
        LoginPage loginpage;
        Properties prop;
        HomePage homepage;

        @BeforeTest
        public void setup() throws InterruptedException {
            basepage = new BasePage();
            prop = basepage.init_prop();
            driver = basepage.init_driver(prop);
            loginpage = new LoginPage(driver);
            homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password") );

        }
        @Test(priority = 1)
        public void verifyHomePageTitle(){
            String Title = homepage.getHomePageTitle();
            System.out.println("Home Page Title is"+Title);
            Assert.assertEquals(Title, Constants.HOME_PAGE_TITLE,"Home Page Title is not Matched");

        }
        @Test(priority = 2)
         public void verifyUserDisplay(){
           String UserDisplayName = homepage.verifyusername();
           System.out.print(UserDisplayName);
           Assert.assertEquals(UserDisplayName,prop.getProperty("HomePageUserName"),"User Display Name Not Matched");
        }
}
