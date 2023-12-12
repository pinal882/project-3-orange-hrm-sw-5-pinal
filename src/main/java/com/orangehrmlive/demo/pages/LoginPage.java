package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Store username, password, Login Button and LOGIN Panel text Locators
 * and create appropriate methods for it.
 */
public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;
    @CacheLookup
    @FindBy(name = "password")
    WebElement password;
@CacheLookup
@FindBy(xpath = "//button[normalize-space()='Login']")
WebElement loginButton;
@CacheLookup
@FindBy(xpath = "//h5[normalize-space()='Login']")
WebElement loginPanel;
    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement userNameFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement passwordFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialErrorMessage;
    public void enterUserName(String name){
        sendTextToElement(userName,name);

    }
    public void enterPassword(String pass){
        sendTextToElement(password,pass);

    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getUserNameFieldBlankErrorMessage() {
        return getTextFromElement(userNameFieldBlankErrorMessage);
    }

    public String getPasswordFieldBlankErrorMessage() {
        return getTextFromElement(passwordFieldBlankErrorMessage);
    }

    public String getInvalidCredentialErrorMessage() {
        return getTextFromElement(invalidCredentialErrorMessage);
    }

    public void loginToApplication(String username,String  password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public String  verifyLoginPanelIsDisplayed(){
        return getTextFromElement(loginPanel);
    }
}
