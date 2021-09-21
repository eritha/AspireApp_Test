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

import models.CommonElement;
import org.openqa.selenium.WebDriver;
import utility.Result;
import utility.helper.Helper;

public class CommonPage {
    private CommonElement commonElement = new CommonElement();
    public WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public Helper getHelper() {
        return new Helper(driver);
    }

    /*
     * Go To any page by URL
     */
    public void Goto(String url) {
        try {
            getHelper().navigateToUrl(url);
        } catch (Exception e) {
            Result.checkFail("Class CommonPage | Method Goto | \nException desc : " + e.getMessage());
        }
    }

    /*
     * Reload page
     */
    public void ReloadPage() {
        try {
            getHelper().refreshPage();
        } catch (Exception e) {
            Result.checkFail("Class CommonPage | Method ReloadPage | \nException desc : " + e.getMessage());
        }
    }

    /*
     * Tab for any page
     */
    public void Tab() {
        try {
            getHelper().pressTabByActionPerform();
        } catch (Exception e) {
            Result.checkFail("Class CommonPage | Method Tab | \nException desc : " + e.getMessage());
        }
    }

    /*
     * Select Aspire Dropdown
     */
    public void SelectAspireDropdown(String locator, String value) {
        try {
            getHelper().findElement(String.format(locator, "false")).click();
            Thread.sleep(300); // Debugging
            getHelper().waitElementIsDisplayed(String.format(locator, "true"));
            Thread.sleep(300); // Debugging
            getHelper().findElement(String.format(commonElement.ele_listbox_value, value)).click();
            Thread.sleep(300); // Debugging
        } catch (Exception e) {
            Result.checkFail("Class CommonPage | Method SelectAspireDropdown | \nLocator: " + locator + "| \nException desc : " + e.getMessage());
        }
    }

    /*
     * Click "Continue" button
     */
    public void ClickButtonContinue() {
        try {
            getHelper().waitForElementVisible(commonElement.ele_btn_submit_continue);
            getHelper().findElement(commonElement.ele_btn_submit_continue).click();
        } catch (Exception e) {
            Result.checkFail("Class CommonPage | Method ClickButtonContinue | Exception desc : " + e.getMessage());
        }
    }
}
