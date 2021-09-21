//
// Copyright 2019 (C) by Phuoc.Ha
//
// Created on : 10-03-2019
// Author     : phuoc.ha
//
//-----------------------------------------------------------------------------
// Revision History (Release 1.0.0.0)
//-----------------------------------------------------------------------------
// VERSION     AUTHOR/      DESCRIPTION OF CHANGE
// OLD/NEW     DATE                RFC NO
//-----------------------------------------------------------------------------
// --/1.0  | phuoc.ha      | Initial Create.
//         | 10-03-2019    |
//---------|---------------|---------------------------------------------------

package Login;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.DialogCountryCode;
import screenObjects.LoginPage;
import screenObjects.OtpPage;
import utility.LogUtils;

import java.lang.reflect.Method;

import static utility.PropertiesUtils.*;

public class TestLogin extends BaseTest {
    String className = this.getClass().getSimpleName();
    private LoginPage loginPage;
    private OtpPage otpPage;
    private DialogCountryCode dialogCountryCode;
    String testCaseName;

    @BeforeClass
    public void beforeClass() {
        super.setUp(aspireUrl);
        loginPage = new LoginPage(driver);
        otpPage = new OtpPage(driver);
        dialogCountryCode = new DialogCountryCode(driver);
        LogUtils.info("------------------------------Test Login-----------------------------");
    }

    @BeforeMethod
    public void setUp(Method method) {
        test = extent.startTest(method.getName()).assignCategory(
                getClass().getSimpleName());
    }

    /*
     * SCENARIO: LOG_001_Verify the Login page should be displayed correctly
     * Precondition: N/I
     * #1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
     * #2: Verify UI of Login page
     */
    @Test
    public void LOG_001_VerifyLoginPageDisplayedCorrectly() {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);
        loginPage.VerifyLoginPageAllElements();
    }

    /*
     * SCENARIO: LOG_002 Verify the existing user email login successfully
     * Precondition: Account should be existed
     * #1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
     * #2: Enter Valid Username email
     * #3: Click "Next" button
     * #4: Verify the home page should be displayed (Ignored due to the KYC)
     */
    @Test
    public void LOG_002_VerifyHomePageDisplayedCorrectlyFromAccountEmail() {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);
        loginPage.VerifyLoginPageAllElements();
        loginPage.InputAccount(accountEmail);
        loginPage.ClickNextButtonToLogin();
        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");
        // Due to the KYC, I can't onboard this account successful
    }

    /*
     * SCENARIO: LOG_003 Verify the existing  phone number login successfully
     * Precondition: Account should be existed
     * #1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
     * #2: Enter Valid Username phone number
     * #3: Click "Next" button
     * #4: Verify the home page should be displayed (Ignored due to the KYC)
     */
    @Test
    public void LOG_003_VerifyHomePageDisplayedCorrectlyFromAccountPhoneNumber() {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);
        loginPage.VerifyLoginPageAllElements();
        loginPage.InputAccount(accountPhone);
        loginPage.ClickNextButtonToLogin();
        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");
        // Due to the KYC, I can't onboard this account successful
    }

    /*
     * SCENARIO: LOG_004 to LOG_012 Verity error message for invalid user login
     * Precondition:
     * #1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
     * #2: Enter Invalid Username
     * #3: Click "Next" button
     * #4: Verify the error message for invalid user
     */
    @Test(dataProvider="InvalidUsersProvider")
    public void LOG_004_VerifyErrorMessageDisplayedCorrectlyForNegativeLogin(String testCaseName,String loginType, String userName, String errorMessage) {
        super.startRecordVideoAfterMethod(className, testCaseName.trim());
        loginPage.Login(userName);
        if (loginType.equals("phone") && userName.length() <= 21){
            dialogCountryCode.VerifyDialogCountryCodeAllElements();
            dialogCountryCode.ClickButtonNext();
        }
        loginPage.VerifyErrorMessageDisplayed(errorMessage);
    }

    /**
     * Invalid data for negative check
     */
    @DataProvider(name="InvalidUsersProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
            {
                { "LOG_004 - Verity unregistered email", "email", "unregisteremail@gmail.com", "The entered email address is invalid." },
                { "LOG_005 - Verity unregistered phone number", "phone", "979566999", "The entered phone number is invalid." },
                { "LOG_006 - Verify empty username", "email", "", "The phone field is required when email is not present." },
                { "LOG_007 - Verify the email contains special character", "email", "#@%^%#$@#$@#.com", "Registered email or phone is invalid" },
                { "LOG_008 - Verify the email missing name", "email", "@gmail.com", "Registered email or phone is invalid" },
                { "LOG_009 - Verify the email mising @ domain", "email", "invalidemail.gmail.com", "Registered email or phone is invalid" },
                { "LOG_010 - Verify invalid email domain", "email", "invalidemaildomain@111.222.333", "The entered email address is invalid." },
                { "LOG_011 - Verify the invalid phone number with length more than 21 characters", "phone", "978542215554454544589663", "Registered email or phone is invalid" },
                { "LOG_012 - Verify the invalid phone number contains string", "phone", "93789ghtrt", "Registered email or phone is invalid" },
            };

    }

    @AfterMethod
    public void tearDown() {
        Constants.sClassName = className;
        super.stopRecordVideoAfterMethod();
        super.screenShotAfterMethod(className, testCaseName);
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
