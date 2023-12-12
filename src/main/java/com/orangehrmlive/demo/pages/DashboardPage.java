package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard text Locator
 * and create appropriate methods for it.
 */
public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']//span[1]")
    WebElement adminTab;
    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
    public void clickOnAdminTab(){
        clickOnElement(adminTab);
    }
}
