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

import models.MobileOtpElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class OtpPage extends CommonPage {
    MobileOtpElement mobileOtpElement;

    public OtpPage(WebDriver driver) {
        super(driver);
        mobileOtpElement = new MobileOtpElement();
    }

    /*
     * Input OTP code
     */
    public void InputOtp(String otpNumber) {
        try {
            Thread.sleep(5000); // Issue page load, handle it later
            for (int i = 0; i < otpNumber.length(); i++) {
                System.out.println(otpNumber.charAt(i));
                getHelper().waitForElementVisible(String.format(mobileOtpElement.ele_input_otp_value, i + 1));
                getHelper().inputValueByActionPerform(String.valueOf(otpNumber.charAt(i)));
                Thread.sleep(500); // Debug action perform
            }
        } catch (Exception e) {
            Result.checkFail("Class MobileOtpPage | Method InputOtp | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click "ResendOtp" button to get the new OTP
     */
    public void ClickButtonResendOtp() {
        try {
            getHelper().findElement(mobileOtpElement.ele_btn_opt_resend).click();
        } catch (Exception e) {
            Result.checkFail("Class MobileOtpPage | Method ClickButtonResendOtp | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements of Mobile Otp Page
     */
    public void VerifyOtpPageAllElements() {
        try {
            getHelper().waitForElementVisible(mobileOtpElement.ele_label_opt_message);
            Assert.assertTrue(getHelper().isElementPresent(mobileOtpElement.ele_icon_back));
//            Assert.assertTrue(getHelper().isElementPresent(mobileOtpElement.ele_btn_opt_change_phone_number));
            Assert.assertTrue(getHelper().isElementPresent(mobileOtpElement.ele_input_otp));
            Assert.assertTrue(getHelper().isElementPresent(mobileOtpElement.ele_btn_opt_resend));
        } catch (Exception e) {
            Result.checkFail("Class MobileOtpPage | Method VerifyMobileOtpPageAllElements | Exception desc : " + e.getMessage());
        }
    }
}