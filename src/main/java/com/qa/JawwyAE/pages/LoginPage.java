package com.qa.JawwyAE.pages;
import com.qa.JawwyAE.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  LoginPage extends BasePage {

    private WebDriver driver;

   //1. By Locators -OR
    By username = By.name("email");
    By password = By.name("password");
    By signinbutton = By.xpath("//*[text()='Login']");


   //2. Create constructor of Page Class

    public LoginPage(WebDriver driver){
        this.driver=driver;

    }

    //3. Page Actions

    public String getLoginPageTitle(){

        return driver.getTitle();
    }
    public boolean verifyloginlink(){

        boolean bo=driver.findElement(signinbutton).isEnabled();
        System.out.println(bo);
        return bo;
    }

    public HomePage doLogin(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(this.signinbutton));
        //WebElement ele = driver.findElement(signinbutton);
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("arguments[0].click()", ele);
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.signinbutton).click();
        Thread.sleep(2000);
        return new HomePage(driver);

    }


}
