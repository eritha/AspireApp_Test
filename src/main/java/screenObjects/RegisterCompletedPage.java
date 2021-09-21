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

import models.RegisterCompletedElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class RegisterCompletedPage extends CommonPage {
    RegisterCompletedElement registerElement;

    public RegisterCompletedPage(WebDriver driver) {
        super(driver);
        registerElement = new RegisterCompletedElement();
    }

    /*
     * Click "Continue" button to go to Personal Detail Page
     */
    public void ClickButtonContinue() {
        try {
            getHelper().waitForElementClickable(registerElement.ele_btn_submit_continue);
            getHelper().findElement(registerElement.ele_btn_submit_continue).isEnabled();
            getHelper().findElement(registerElement.ele_btn_submit_continue).click();
        } catch (Exception e) {
            Result.checkFail("Class RegisterCompletedPage | Method ClickButtonLogin | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify new account registered
     */
    public void VerifyRegisterNewAccountSuccessfully() {
        try {
            getHelper().waitForElementVisible(registerElement.ele_icon_register_completed);
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_wohoo));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_message_success));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_btn_submit_continue));

            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_wohoo, "Wohoo!"));
//            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_message_success, "You have successfully verified your email. You’re on to a great start!"));
//            Singapore => You have successfully verified your mobile number. You’re on to a great start!
//            Vietnam => You have successfully verified your email. You’re on to a great start!
        } catch (Exception e) {
            Result.checkFail("Class RegisterCompletedPage | Method VerifyRegisterNewAccountSuccessfully | Exception desc : " + e.getMessage());
        }
    }
}
