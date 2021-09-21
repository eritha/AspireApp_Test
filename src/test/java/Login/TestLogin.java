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
    String testCaseName;
    int count = 0;

    @BeforeMethod
    public void setUp(Method method) {
        super.setUp(aspireUrl);
        loginPage = new LoginPage(driver);
        otpPage = new OtpPage(driver);
        LogUtils.info("------------------------------Test Login-----------------------------");
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

    @AfterMethod
    public void tearDown() {
        Constants.sClassName = className;
        super.stopRecordVideoAfterMethod();
        super.screenShotAfterMethod(className, testCaseName);
        super.afterMethod();
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
