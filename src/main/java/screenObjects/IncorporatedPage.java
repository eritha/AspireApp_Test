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

import models.IncorporatedElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class IncorporatedPage extends CommonPage {
    IncorporatedElement incorporatedElement;

    public IncorporatedPage(WebDriver driver) {
        super(driver);
        incorporatedElement = new IncorporatedElement();
    }

    /*
     * Verify All elements of incorporated page
     */
    public void VerifyAspireIncorporatedPageAllElements() {
        try {
            getHelper().waitForElementVisible(incorporatedElement.ele_icon_incorporated);
            Assert.assertTrue(getHelper().isElementPresent(incorporatedElement.ele_incorporated_overview_title));
            Assert.assertTrue(getHelper().isElementPresent(incorporatedElement.ele_incorporated_overview_content));
            Assert.assertTrue(getHelper().isElementPresent(incorporatedElement.ele_btn_incorporated_how_it_work));
            Assert.assertTrue(getHelper().isElementPresent(incorporatedElement.ele_btn_get_start));

            Assert.assertTrue(getHelper().elementTextShoudlBe(incorporatedElement.ele_incorporated_overview_title, "Incorporate your business in Singapore with Aspire Kickstart"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(incorporatedElement.ele_incorporated_overview_content, "Your one-stop solution for starting a business in Singapore. Register your business and open a business account - fast, transparent, and 100% online."));
            Assert.assertTrue(getHelper().elementTextShoudlBe(incorporatedElement.ele_btn_incorporated_how_it_work, "How it works +"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(incorporatedElement.ele_btn_get_start, "Get Started"));

        } catch (Exception e) {
            Result.checkFail("Class IncorporatedPage | Method VerifyIncorporatedPageAllElements | Exception desc : " + e.getMessage());
        }
    }
}
