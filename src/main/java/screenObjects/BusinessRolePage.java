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

import models.BusinessRoleElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class BusinessRolePage extends CommonPage {
    BusinessRoleElement businessRoleElement;

    public BusinessRolePage(WebDriver driver) {
        super(driver);
        businessRoleElement = new BusinessRoleElement();
    }

    /*
     * Register new account as Director
     */
    public void SelectToOpenNewAccountAsDirector() {
        try {
            getHelper().waitForElementVisible(businessRoleElement.ele_account_director_section);
            getHelper().findElement(businessRoleElement.ele_account_director_section).click();
        } catch (Exception e) {
            Result.checkFail("Class BusinessRolePage | Method SelectToOpenNewAccountAsDirector | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Register new account as Non-Director
     */
    public void SelectToOpenNewAccountAsNonDirector() {
        try {
            Thread.sleep(3000);
            getHelper().waitForElementVisible(businessRoleElement.ele_account_employee_section);
            getHelper().findElement(businessRoleElement.ele_account_employee_section).click();
        } catch (Exception e) {
            Result.checkFail("Class BusinessRolePage | Method SelectToOpenNewAccountAsNonDirector | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Register new account as Freelancer
     */
    public void SelectToOpenNewAccountAsFreelancer() {
        try {
            getHelper().waitForElementVisible(businessRoleElement.ele_account_freelancer_section);
            getHelper().findElement(businessRoleElement.ele_account_freelancer_section).click();
        } catch (Exception e) {
            Result.checkFail("Class BusinessRolePage | Method SelectToOpenNewAccountAsFreelancer | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Register new account to incorporate my company
     */
    public void SelectToOpenNewToIncorporateMyCompany() {
        try {
            getHelper().waitForElementVisible(businessRoleElement.ele_account_incorporate_section);
            getHelper().findElement(businessRoleElement.ele_account_incorporate_section).click();
        } catch (Exception e) {
            Result.checkFail("Class BusinessRolePage | Method SelectToOpenNewToIncorporateMyCompany | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Register Page
     */
    public void VerifyTheBusinessPageShouldBeDisplayed() {
        try {
            getHelper().waitForElementVisible(businessRoleElement.ele_title_open_aspire_account_section);
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_icon_back));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_account_director_section));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_icon_account_director));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_account_employee_section));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_icon_account_employee));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_account_freelancer_section));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_icon_account_freelancer));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_title_incorporate_aspire_account_section));
            Assert.assertTrue(getHelper().isElementPresent(businessRoleElement.ele_icon_account_incorporate));

            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_title_open_aspire_account_section, "I want to open an Aspire account"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_label_account_director, "I am a registered director of the company"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_label_account_employee, "I am a non-registered director or an employee"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_label_account_freelancer, "I am a freelancer"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_title_incorporate_aspire_account_section, "I want to incorporate my company"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(businessRoleElement.ele_label_account_incorporate, "I am an entrepreneur and I want to incorporate in Singapore"));

        } catch (Exception e) {
            Result.checkFail("Class BusinessRolePage | Method VerifyTheBusinessPageShouldBeDisplayed | Exception desc : " + e.getMessage());
        }
    }
}
