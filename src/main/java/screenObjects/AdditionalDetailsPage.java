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

import models.AdditionalDetailsElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class AdditionalDetailsPage extends CommonPage {
    AdditionalDetailsElement additionalDetailsElement;

    public AdditionalDetailsPage(WebDriver driver) {
        super(driver);
        additionalDetailsElement = new AdditionalDetailsElement();
    }

    /*
     * Select dropdown nationality
     */
    public void SelectDropdownNationality(String nationality) {
        try {
            SelectAspireDropdown(additionalDetailsElement.ele_dropdown_user_detail_nationality, nationality);
        } catch (Exception e) {
            Result.checkFail("Class PersonalDetailsPage | Method SelectDropdownNationality | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Check checkbox "My company is not registered yet"
     */
    public void ClickCheckboxCompanyNotRegisterYet() {
        try {
            getHelper().waitForElementVisible(additionalDetailsElement.ele_ckb_company_not_register);
            Thread.sleep(1000); // Debugging
            getHelper().findElement(additionalDetailsElement.ele_ckb_company_not_register).click();
        } catch (Exception e) {
            Result.checkFail("Class PersonalDetailsPage | Method ClickCheckboxCompanyNotRegisterYet | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Select solution are you looking for
     */
    public void SelectDropdownListSolutions(String[] solutions) {
        try {
            getHelper().waitForElementVisible(String.format(additionalDetailsElement.ele_dropdown_user_detail_search, "false"));
            Thread.sleep(300); // Debugging
            getHelper().findElement(String.format(additionalDetailsElement.ele_dropdown_user_detail_search, "false")).click();
            Thread.sleep(300); // Debugging
            getHelper().waitElementIsDisplayed(String.format(additionalDetailsElement.ele_dropdown_user_detail_search, "true"));
            Thread.sleep(300); // Debugging
            for (String solution : solutions) {
                Thread.sleep(300); // Debugging
                getHelper().focusElementByJavaScript(String.format(additionalDetailsElement.ele_listbox_value, solution));
                getHelper().findElement(String.format(additionalDetailsElement.ele_listbox_value, solution)).click();
            }
            getHelper().findElement(String.format(additionalDetailsElement.ele_dropdown_user_detail_search, "true")).click();
            Thread.sleep(300); // Debu
        } catch (Exception e) {
            Result.checkFail("Class PersonalDetailsPage | Method SelectDropdownSolution | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input additional-details Form
     */
    public void InputAdditionalDetailsForm(String nationality, boolean isCompanyRegister, String[] solutions) {
        try {
            if (isCompanyRegister) {
                SelectDropdownNationality(nationality);
            } else {
                ClickCheckboxCompanyNotRegisterYet();
            }
            SelectDropdownListSolutions(solutions);
        } catch (Exception e) {
            Result.checkFail("Class PersonalDetailsPage | Method InputAdditionalDetailsForm | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in additional-details Page
     */
    public void VerifyAdditionalDetailsPageAllElements() {
        try {
            getHelper().waitForElementVisible(additionalDetailsElement.ele_label_user_detail_nationality);
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_icon_back));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_icon_user_detail_nationality));
            Assert.assertTrue(getHelper().isElementPresent(String.format(additionalDetailsElement.ele_dropdown_user_detail_nationality, "false")));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_ckb_company_not_register));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_label_company_not_register));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_icon_user_detail_search));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_label_user_detail_search));
            Assert.assertTrue(getHelper().isElementPresent(String.format(additionalDetailsElement.ele_dropdown_user_detail_search, "false")));
            Assert.assertTrue(getHelper().isElementPresent(additionalDetailsElement.ele_btn_submit_continue));

            Assert.assertTrue(getHelper().elementTextShoudlBe(additionalDetailsElement.ele_label_user_detail_nationality, "Where is your company registered?"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(additionalDetailsElement.ele_label_company_not_register, "My company is not registered yet"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(additionalDetailsElement.ele_label_user_detail_search, "What solutions are you looking for?"));

        } catch (Exception e) {
            Result.checkFail("Class PersonalDetailsPage | Method VerifyPersonalDetailsPageAllElements | Exception desc : " + e.getMessage());
        }
    }
}
