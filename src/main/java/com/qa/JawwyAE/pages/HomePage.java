package com.qa.JawwyAE.pages;

import com.qa.JawwyAE.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    By userdisplay = By.xpath("//span[@class=\"user-display\"]");
    By casebutton = By.xpath("//span[@class=\"item-text\"][text()='Cases']");
    By createcase = By.xpath("//button[@class=\"ui linkedin button\"][text()='Create']");

    public HomePage(WebDriver driver){
        this.driver=driver;

    }
    public String getHomePageTitle(){

        return driver.getTitle();
    }

    public String verifyusername() {
        if (driver.findElement(userdisplay).isDisplayed()){
        return driver.findElement(userdisplay).getText();
    }
        return null;
    }

}
