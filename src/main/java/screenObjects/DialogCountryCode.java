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

import models.DialogCountryCodeElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class DialogCountryCode extends CommonPage {
    DialogCountryCodeElement dialogCountryCodeElement;

    public DialogCountryCode(WebDriver driver) {
        super(driver);
        dialogCountryCodeElement = new DialogCountryCodeElement();
    }

    /*
     * Input phone number to register form
     */
    public void InputPhoneNumber(String country, String phoneNumber) {
        try {
            SelectAspireDropdown(dialogCountryCodeElement.ele_cbx_phone, country);
            getHelper().findElement(dialogCountryCodeElement.ele_input_registered_phone_number).sendKeys(phoneNumber);
        } catch (Exception e) {
            Result.checkFail("Class DialogCountryCode | Method InputPhoneNumber | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click the dialog button next to check phone number
     */
    public void ClickButtonNext() {
        try {
            getHelper().waitForElementVisible(dialogCountryCodeElement.ele_button_next);
            getHelper().findElement(dialogCountryCodeElement.ele_button_next).click();
        } catch (Exception e) {
            Result.checkFail("Class DialogCountryCode | Method ClickButtonNext | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Dialog Country Code
     */
    public void VerifyDialogCountryCodeAllElements() {
        try {
            getHelper().waitForElementVisible(dialogCountryCodeElement.ele_label_dialog_title);
            Assert.assertTrue(getHelper().isElementPresent(dialogCountryCodeElement.ele_label_dialog_sub_title));
            Assert.assertTrue(getHelper().isElementPresent(dialogCountryCodeElement.ele_icon_dialog_registered_mobile_num));
            Assert.assertTrue(getHelper().isElementPresent(dialogCountryCodeElement.ele_label_dialog_registered_mobile_num));
            Assert.assertTrue(getHelper().isElementPresent(dialogCountryCodeElement.ele_input_registered_phone_number));
            Assert.assertTrue(getHelper().isElementPresent(dialogCountryCodeElement.ele_button_next));

            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogCountryCodeElement.ele_label_dialog_title, "Choose country code"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogCountryCodeElement.ele_label_dialog_sub_title, "Hey, we are unable to auto-detect the country code. Please select the country code for your mobile number."));
            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogCountryCodeElement.ele_label_dialog_registered_mobile_num, "Registered mobile number"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogCountryCodeElement.ele_button_next, "Next"));
        } catch (Exception e) {
            Result.checkFail("Class DialogCountryCode | Method VerifyDialogCountryCodeAllElements | Exception desc : " + e.getMessage());
        }
    }
}
