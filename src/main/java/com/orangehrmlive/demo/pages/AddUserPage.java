package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * User Role Drop Down, Employee Name, Username, Status Drop Down, Password, Confirm Password,
 * Save and Cancle Button Locators and it's actions
 */
public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addUserText;
    @CacheLookup
    @FindBy(xpath = "(//div[@class = 'oxd-select-wrapper'])[1]")
    WebElement userRole;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement adminOptionInUserRoleDropDownInAddUser;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'ESS')]")
    WebElement ESSOptionInUserRoleDropDownInAddUser;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;
    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]")
    WebElement userName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text-input'][normalize-space()='Disabled']")
    WebElement statusDropdown;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disabledStatusOptionInAddUser;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Enabled']")
    WebElement enabledStatusOptionInAddUser;
   @CacheLookup
   @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
   WebElement passwordfield;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButtonInAddUser;


    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullySavedMessageInAddUser;

    public String verifyAddUserText(){
        return getTextFromElement(addUserText);

    }
    public void selectUserRole(){
        Actions action = new Actions(driver);
        action.moveToElement(userRole).perform();
    }
    public void mouseHoverAndCLickOnAdminOptionInUserRoleDropDownInAddUser() {
        clickOnElement(adminOptionInUserRoleDropDownInAddUser);
    }
    public void mouseHoverAndCLickOnESSOptionInUserRoleDropDownInAddUser() {
        clickOnElement(ESSOptionInUserRoleDropDownInAddUser);
    }
    public void enterEmployeeName(String name){
        sendTextToElement(employeeNameField,name);

    }
    public void enterUserName(String name){
        sendTextToElement(userName,name);
    }
    public void selectStatus(String status){
        selectByVisibleTextFromDropDown(statusDropdown,status);
    }
    public void mouseHoverAndClickOnDisabledOptionInAddUser() {
        mouseHoverToElementAndClick(disabledStatusOptionInAddUser);
    }
    public void mouseHoverAndClickOnEnabledOptionInAddUser() {
        mouseHoverToElementAndClick(enabledStatusOptionInAddUser);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordfield,password);
    }
    public void confirmPassword(String pass){
        sendTextToElement(confirmPassword,pass);
    }
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }
    public void clickOnCancelButtonInAddUser() {
        clickOnElement(cancelButtonInAddUser);
    }

    public String getSuccessfullySavedMessageInAddUser() {
        return getTextFromElement(successfullySavedMessageInAddUser);
    }
}
