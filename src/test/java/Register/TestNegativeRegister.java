//
// Copyright 2021 (C) by Phuoc.Ha
//
// Created on : 19-09-2021
// Author     : phuoc.ha
//
//-----------------------------------------------------------------------------
// Revision History (Release 1.0.0.0)
//-----------------------------------------------------------------------------
// VERSION     AUTHOR/      DESCRIPTION OF CHANGE
// OLD/NEW     DATE                RFC NO
//-----------------------------------------------------------------------------
// --/1.0  | phuoc.ha      | Initial Create.
//         | 19-09-2021    |
//---------|---------------|---------------------------------------------------

package Register;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.LoginPage;
import screenObjects.RegisterPage;
import utility.LogUtils;

import java.lang.reflect.Method;

import static utility.PropertiesUtils.*;


public class TestNegativeRegister extends BaseTest {
    String className = this.getClass().getSimpleName();
    private LoginPage loginPage;
    private RegisterPage registerPage;
    String testCaseName;
    int count = 0;

    @BeforeClass
    public void beforeClass() {
        super.setUp(aspireUrl);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        LogUtils.info("------------------------------Test Register -----------------------------");
    }

    /*
     * SCENARIO: REG_007 to REG_015 Verity error messages for all register fields
     * Precondition:
     * #1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
     * #2: Click register link
     * #3: Enter Valid All register fields and check term condition
     * #4: Input invalid fields into the register form
     * #5: Verify the error messages displayed correctly for all fields
     */
    @Test(dataProvider = "InvalidUsersInfoProvider")
    public void REG_007_VerifyErrorMessagesDisplayedForNegativeRegisterForm(String testCaseName, String fieldType, String value, String errorMessage) {
        test = extent.startTest(testCaseName.trim());
        super.startRecordVideoAfterMethod(className, testCaseName.trim());

        if (count == 0) {
            loginPage.Goto(aspireUrl + "register");
            registerPage.VerifyRegisterPageAllElements();
            registerPage.InputRegisterForm("Phuoc Ha", "Erit", accountEmail, "Singapore (+65)", accountPhone, "Google", "");
            registerPage.ClickCheckboxTermsAndConditions();
        }

        switch (fieldType) {
            case "fullname":
                registerPage.InputFullName(value);
                registerPage.Tab();
                registerPage.PageShouldShowTheFullNameErrorMessage(errorMessage);
                break;
            case "email":
                registerPage.InputEmailAddress(value);
                registerPage.Tab();
                registerPage.PageShouldShowTheEmailErrorMessage(errorMessage);
                break;
            case "phone":
                registerPage.InputPhoneNumber("Singapore (+65)", value);
                if (testCaseName.contains("fulfilled")) {
                    String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
                    registerPage.InputFullName("Erit Ha");
                    registerPage.InputEmailAddress(emailAddress);
                    registerPage.ClickButtonContinue();
                } else {
                    registerPage.Tab();
                }
                registerPage.PageShouldShowThePhoneNumberErrorMessage(errorMessage);
                break;
        }
        count++;
    }

    /**
     * Invalid data for negative check
     */
    @DataProvider(name = "InvalidUsersInfoProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"REG_007 - Verity empty fullname", "fullname", "", "Full Name as per ID is required."},
                        {"REG_008 - Verity empty email", "email", "", "Email address is required."},
                        {"REG_009 - Verify empty phone number", "phone", "", "Mobile number is required."},
                        {"REG_010 - Verify the email contains special character", "email", "#@%^%#$@#$@#.com", "Email address must be a valid email address."},
                        {"REG_011 - Verify the email missing name", "email", "@gmail.com", "Email address must be a valid email address."},
                        {"REG_012 - Verify the email missing @ domain", "email", "invalidemail.gmail.com", "Email address must be a valid email address."},
//                        { "REG_013 - Verify invalid email domain", "email", "invalidemaildomain@111.222.333", "Email address must be a valid email address." },
                        {"REG_014 - Verify the invalid phone number with length more than 14 characters", "phone", "9785422155569", "Mobile number may not be greater than 14 digits."},
                        {"REG_015 - Verify the invalid phone number contains string - fulfilled", "phone", "93789ghtrt", "Incorrect phone format for phone., The phone format is invalid."},
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
