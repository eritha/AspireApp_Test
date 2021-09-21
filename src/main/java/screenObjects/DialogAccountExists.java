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

import models.DialogAccountExistsElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class DialogAccountExists extends CommonPage {
    DialogAccountExistsElement dialogAccountExistsElement;

    public DialogAccountExists(WebDriver driver) {
        super(driver);
        dialogAccountExistsElement = new DialogAccountExistsElement();
    }

    /*
     * Click the button close the dialog
     */
    public void ClickButtonCloseDialog() {
        try {
            getHelper().waitForElementVisible(dialogAccountExistsElement.ele_icon_dialog_close);
            getHelper().findElement(dialogAccountExistsElement.ele_icon_dialog_close).click();
        } catch (Exception e) {
            Result.checkFail("Class DialogAccountExists | Method ClickButtonCloseDialog | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Dialog Account exists Code
     */
    public void VerifyDialogAccountexistsAllElements(String emailAddress, String phoneNumber) {
        try {
            getHelper().waitForElementVisible(dialogAccountExistsElement.ele_label_dialog_title);
            Assert.assertTrue(getHelper().isElementPresent(dialogAccountExistsElement.ele_icon_dialog_close));
            Assert.assertTrue(getHelper().isElementPresent(dialogAccountExistsElement.ele_label_dialog_content));
            Assert.assertTrue(getHelper().isElementPresent(dialogAccountExistsElement.ele_button_login));

            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogAccountExistsElement.ele_label_dialog_title, "Account exists, try login instead!"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogAccountExistsElement.ele_label_dialog_content, "We noticed that an account is already associated with +65" + phoneNumber + " and " + emailAddress));
            Assert.assertTrue(getHelper().elementTextShoudlBe(dialogAccountExistsElement.ele_button_login, "Login"));
        } catch (Exception e) {
            Result.checkFail("Class DialogAccountExists | Method VerifyDialogAccountexistsAllElements | Exception desc : " + e.getMessage());
        }
    }
}
