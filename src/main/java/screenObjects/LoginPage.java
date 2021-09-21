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

package screenObjects;

import models.LoginElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class LoginPage extends CommonPage {
    LoginElement loginElement;

    public LoginPage(WebDriver driver) {
        super(driver);
        loginElement = new LoginElement();
    }

    /*
     * Input Account name
     */
    public void InputAccount(String accName) {
        try {
            getHelper().waitForElementVisible(loginElement.ele_input_user_login);
            getHelper().clearWebField(loginElement.ele_input_user_login);
            getHelper().findElement(loginElement.ele_input_user_login).sendKeys(accName);
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method InputAccount | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click "Remember me" checkbox
     */
    public void ClickCheckboxRememberMe() {
        try {
            getHelper().findElement(loginElement.ele_ckb_remember_me).click();
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method ClickCheckboxRememberMe | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click "Register" to register new account
     */
    public void ClickLinkRegister() {
        try {
            getHelper().waitForElementClickable(loginElement.ele_link_register);
            getHelper().findElement(loginElement.ele_link_register).click();
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method ClickLinkRegister | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click "Next" button to login
     */
    public void ClickNextButtonToLogin() {
        try {
            getHelper().findElement(loginElement.ele_btn_next).click();
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method ClickNextButtonToLogin | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Method Login to login Aspire with existing account
     * Return MobileOtpPage
     */
    public void Login(String userName) {
        try {
            InputAccount(userName);
            ClickNextButtonToLogin();
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method Login | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Login Page
     */
    public void VerifyLoginPageAllElements() {
        try {
            getHelper().waitForElementVisible(loginElement.ele_icon_user_login);
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_label_user_login));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_input_user_login));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_ckb_label_remember_me));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_ckb_remember_me));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_label_dont_have_account));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_link_register));
            Assert.assertTrue(getHelper().isElementPresent(loginElement.ele_btn_next));

            Assert.assertTrue(getHelper().elementTextShoudlBe(loginElement.ele_label_user_login, "Registered email or phone"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(loginElement.ele_ckb_label_remember_me, "Remember me"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(loginElement.ele_label_dont_have_account, "Don’t have an account yet? Register"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(loginElement.ele_link_register, "Register"));
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method VerifySignUpPageAllElements | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify the error message for invalid username input
     */
    public void VerifyErrorMessageDisplayed(String errorMessage) {
        try {
            getHelper().waitForElementVisible(loginElement.ele_label_user_error_msg);
            Assert.assertTrue(getHelper().elementTextShoudlBe(loginElement.ele_label_user_error_msg, errorMessage));
        } catch (Exception e) {
            Result.checkFail("Class LoginPage | Method VerifyErrorMessageDisplayed | Exception desc : " + e.getMessage());
        }
    }
}