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

import models.UnincorporatedElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class UnincorporatedPage extends CommonPage {
    UnincorporatedElement uncorporatedElement;

    public UnincorporatedPage(WebDriver driver) {
        super(driver);
        uncorporatedElement = new UnincorporatedElement();
    }

    /*
     * Verify All elements in Unincorporated Page
     */
    public void VerifyUnincorporatedPageAllElements(String nationality) {
        try {
            getHelper().waitForElementVisible(uncorporatedElement.ele_icon_unincorporated);
            Assert.assertTrue(getHelper().isElementPresent(uncorporatedElement.ele_unincorporated_title));
            Assert.assertTrue(getHelper().isElementPresent(uncorporatedElement.ele_unincorporated_content));
            Assert.assertTrue(getHelper().isElementPresent(uncorporatedElement.ele_btn_learn_more));

            Assert.assertTrue(getHelper().elementTextShoudlBe(uncorporatedElement.ele_unincorporated_title, "We will be there soon!"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(uncorporatedElement.ele_unincorporated_content, "Aspire account is not yet available in " + nationality + ". We will notify you if we expand in the future!"));
        } catch (Exception e) {
            Result.checkFail("Class UnincorporatedPage | Method VerifyUnincorporatedPageAllElements | Exception desc : " + e.getMessage());
        }
    }
}
