package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customelisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test (groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully() {
        //Login to Application
        loginPage.loginToApplication("Admin","admin123");
        //click On "Admin" Tab
dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(),"System Users");
        //click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //Verify "Add User" Text
        addUserPage.verifyAddUserText();
        //Select User Role "Admin"
        addUserPage.selectUserRole();
        addUserPage.mouseHoverAndCLickOnAdminOptionInUserRoleDropDownInAddUser();
        //enter Employee Name "Ananya Dash"
addUserPage.enterEmployeeName("Nina Patel");
        //enter Username
        addUserPage.enterUserName("Prime");
        //Select status "Disable"
        addUserPage.selectStatus("disabled");
        addUserPage.mouseHoverAndClickOnDisabledOptionInAddUser();
        //enter psaaword
        addUserPage.enterPassword("admin123");
        //enter Confirm Password
addUserPage.confirmPassword("admin123");
        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        //verify message "Successfully Saved"
        Assert.assertEquals(addUserPage.getSuccessfullySavedMessageInAddUser()," Successfully Saved");
    }

    @Test (groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        //Login to Application
        loginPage.loginToApplication("Admin","admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(),"System Users");
        //Enter Username
addUserPage.enterUserName("Admin");
        //Select User Role
        viewSystemUsersPage.clickOnUserRoleDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers();
        //Select Satatus
        viewSystemUsersPage.clickOnStatusDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndCLickOndDisableStatusOptionInSystemUsers();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButtonInSystemUsers();
        //Verify the User should be in Result list.
        Assert.assertEquals(viewSystemUsersPage.getDataFromUserNameInRecord(),"Prime");
    }

    @Test (groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        //Login to Application
        loginPage.loginToApplication("Admin","admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(),"System Users");
        //Enter Username
        addUserPage.enterUserName("Admin");
        //Select User Role
        viewSystemUsersPage.clickOnUserRoleDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers();
        //Select Satatus
        viewSystemUsersPage.clickOnStatusDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndCLickOndDisableStatusOptionInSystemUsers();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButtonInSystemUsers();
        //Verify the User should be in Result list.
        Assert.assertEquals(viewSystemUsersPage.getDataFromUserNameInRecord(),"Prime");
        //Click on Check box
        //Click on Delete Button
        //Popup will display
        //Click on Ok Button on Popup
        //verify message "Successfully Deleted"
    }

    @Test (groups = {"regression"},dataProvider = "Desktops",dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound() {
        //Login to Application
        loginPage.loginToApplication("Admin","admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(),"System Users");
        //Enter Username <username>
        addUserPage.enterUserName("Admin");
        //Select User Role <userRole>
        //Enter EmployeeName <employeeName>
        //Select Satatus <status>
        //Click on "Search" Button verify message "(1) Record Found"
        //Verify username <username>
        //Click on Reset Tab
    }
}
