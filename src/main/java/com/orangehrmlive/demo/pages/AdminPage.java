package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * UserManagement, Job, Organization Tabs Locators and it's actions
 */
public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement logo;
    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logout;

public void clickOnUserLogo(){
    clickOnElement(logo);
}
public void verifyLogoIsDisplayed(){
    logo.isDisplayed();
}
public void mouseHoverAndClickOnLogout(){
    mouseHoverToElementAndClick(logout);
}


    }

