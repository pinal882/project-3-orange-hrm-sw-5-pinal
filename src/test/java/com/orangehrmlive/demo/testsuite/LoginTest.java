package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();

    }

    @Test (groups = {"sanity","smoke","regression"})
    public void verifyUserShouldLoginSuccessFully(){
       //Enter username
        loginPage.enterUserName("Admin");
        //Enter password
loginPage.enterPassword("admin123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify "WelCome" Message
    }
    @Test (groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        //Login To The application
        loginPage.loginToApplication("Admin","admin123");
        //Verify Logo is Displayed
        adminPage.verifyLogoIsDisplayed();
    }
    @Test (groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully(){
        //Login To The application
        loginPage.loginToApplication("Admin","admin123");
        //Click on User Profile logo
        adminPage.clickOnUserLogo();
        //Mouse hover on "Logout" and click
        adminPage.mouseHoverAndClickOnLogout();
        //Verify the text "Login Panel" is displayed
        loginPage.verifyLoginPanelIsDisplayed();
    }
    @Test (groups = {"regression"},dataProvider = "credentials",dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(){
      //Enter username <username>
        loginPage.enterUserName("Admin");
        //Enter password <password>
        loginPage.enterPassword("admin123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify Error message <errorMessage>
        Assert.assertEquals(loginPage.getUserNameFieldBlankErrorMessage(),"");
        Assert.assertEquals(loginPage.getPasswordFieldBlankErrorMessage(),"");
        Assert.assertEquals(loginPage.getInvalidCredentialErrorMessage(),"");
    }
}
