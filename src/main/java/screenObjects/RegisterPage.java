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

import models.AspireDialogElement;
import models.RegisterElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class RegisterPage extends CommonPage {
    RegisterElement registerElement;
    AspireDialogElement aspireDialogElement;

    String email = "t" + System.currentTimeMillis() + "@yopmail.com";

    public RegisterPage(WebDriver driver) {
        super(driver);
        registerElement = new RegisterElement();
        aspireDialogElement = new AspireDialogElement();
    }

    /*
     * Input fullname to register form
     */
    public void InputFullName(String fullName) {
        try {
            getHelper().waitForElementClickable(registerElement.ele_input_full_name);
            getHelper().clearWebField(registerElement.ele_input_full_name);
            getHelper().findElement(registerElement.ele_input_full_name).sendKeys(fullName);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputFullName | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Preferred name
     */
    public void InputPreferredName(String fullName) {
        try {
            getHelper().waitForElementClickable(registerElement.ele_input_preferred_name);
            getHelper().findElement(registerElement.ele_input_preferred_name).sendKeys(fullName);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputPreferredName | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input email address to register form
     */
    public void InputEmailAddress(String email) {
        try {
            getHelper().waitForElementClickable(registerElement.ele_input_email);
            getHelper().clearWebField(registerElement.ele_input_email);
            getHelper().findElement(registerElement.ele_input_email).sendKeys(email);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputEmailAddress | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input phone number to register form
     */
    public void InputPhoneNumber(String country, String phoneNumber) {
        try {
            SelectAspireDropdown(registerElement.ele_cbx_phone, country);
            getHelper().clearWebField(registerElement.ele_input_phone);
            getHelper().findElement(registerElement.ele_input_phone).sendKeys(phoneNumber);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputPhoneNumber | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input "Where did you hear about us?" to register form
     */
    public void InputHeardAbout(String heardFrom) {
        try {
            SelectAspireDropdown(registerElement.ele_input_heard_about, heardFrom);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputHeardAbut | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input "Referral/promo code" to register form
     */
    public void InputReferralPromoCode(String code) {
        try {
            getHelper().waitForElementClickable(registerElement.ele_input_referral_code);
            getHelper().findElement(registerElement.ele_input_referral_code).sendKeys(code);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputReferralPromoCode | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Apply "Referral/promo code" to register form
     */
    public void ApplyReferralPromoCode(String code) {
        try {
            getHelper().waitForElementClickable(registerElement.ele_btn_apply_referral_code);
            getHelper().findElement(registerElement.ele_btn_apply_referral_code).click();
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method ApplyReferralPromoCode | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Check checkbox "Terms and Conditions agreement" to register form
     */
    public void ClickCheckboxTermsAndConditions() {
        try {
            getHelper().waitForElementClickable(registerElement.ele_ckb_agreement);
            Thread.sleep(1000); // Debugging
            getHelper().findElement(registerElement.ele_ckb_agreement).click();
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method ClickTermsAndConditions | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Register Form
     */
    public void InputRegisterForm(String fullName, String preferredName, String email, String country, String phoneNumber, String heardAbout, String referalCode) {
        try {
            InputFullName(fullName);
            InputPreferredName(preferredName);
            InputEmailAddress(email);
            InputPhoneNumber(country, phoneNumber);
            InputHeardAbout(heardAbout);
            InputReferralPromoCode(referalCode);
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method InputRegisterForm | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Register Page
     */
    public void VerifyRegisterPageAllElements() {
        try {
            getHelper().waitForElementDisplay(registerElement.ele_label_full_name, 5);
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_full_name));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_input_full_name));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_preferred_name));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_preferred_name));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_input_preferred_name));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_email));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_email));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_input_email));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_phone));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_phone));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_input_phone));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_heard_about));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_heard_about));
            Assert.assertTrue(getHelper().isElementPresent(String.format(registerElement.ele_input_heard_about, "false")));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_referral_code));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_icon_referral_code));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_input_referral_code));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_ckb_agreement));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_agreement));

            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_label_already_registered));
            Assert.assertTrue(getHelper().isElementPresent(registerElement.ele_link_login));

            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_full_name, "Full Name as per ID"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_email, "Email address"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_phone, "Mobile number"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_heard_about, "Where did you hear about us?"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_referral_code, "Referral/promo code"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_agreement, "I have read and agree with the Terms and Conditions, Use Policy, and Privacy Policy."));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_already_registered, "Already have an account? Login"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_link_login, "Login"));

        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method VerifyRegisterPageAllElements | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify the Dialog Account existed
     */
    public void TheDialogAccountExistedShouldBeShown(String dialogTitle) {
        try {
            getHelper().waitElementIsDisplayed(aspireDialogElement.ele_label_dialog_title);
            Assert.assertTrue(getHelper().elementTextShoudlBe(aspireDialogElement.ele_label_dialog_title, dialogTitle));
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method TheDialogAccountExistedShouldBeShown | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify the invalid full name
     */
    public void PageShouldShowTheFullNameErrorMessage(String msgInvalid) {
        try {
            getHelper().isElementPresent(registerElement.ele_icon_full_name_error);
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_full_name_error, msgInvalid));
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method PageShouldShowTheInvalidFullNameMessage | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify the invalid email
     */
    public void PageShouldShowTheEmailErrorMessage(String errorMsg) {
        try {
            getHelper().isElementPresent(registerElement.ele_icon_email_error);
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_email_error, errorMsg));
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method PageShouldShowTheEmailErrorMessage | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify the invalid phone
     */
    public void PageShouldShowThePhoneNumberErrorMessage(String errorMsg) {
        try {
            getHelper().isElementPresent(registerElement.ele_icon_phone_error);
            Assert.assertTrue(getHelper().elementTextShoudlBe(registerElement.ele_label_phone_error, errorMsg));
        } catch (Exception e) {
            Result.checkFail("Class RegisterPage | Method PageShouldShowThePhoneNumberErrorMessage | Exception desc : " + e.getMessage());
        }
    }
}
