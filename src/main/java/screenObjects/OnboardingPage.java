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

import models.OnboardingElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class OnboardingPage extends CommonPage {
    OnboardingElement onboardingElement;

    public OnboardingPage(WebDriver driver) {
        super(driver);
        onboardingElement = new OnboardingElement();
    }

    /*
     * Click button "Get Started" to Register via Myinfo Business
     */
    public void ClickButtonGetStartedMyInfoBusiness() {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_button_myinfo_business_get_started);
            getHelper().findElement(onboardingElement.ele_button_myinfo_business_get_started).click();
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method ClickButtonGetStartedMyInfoBusiness | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Click button "Get Started" for Standard Registration
     */
    public void ClickButtonGetStartedStandardRegistration() {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_button_standard_registration_get_started);
            getHelper().findElement(onboardingElement.ele_button_standard_registration_get_started).click();
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method ClickButtonGetStartedStandardRegistration | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Onboarding Page
     */
    public void VerifyOnboardingPageAllElements() {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_icon_myinfo_business);
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_back));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_myinfo_business));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_myinfo_business_register_time));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_myinfo_business_content0));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_myinfo_business_content1));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_myinfo_business_content2));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_button_myinfo_business_get_started));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_standard_registration));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_standard_registration));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_standard_registration_register_time));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_standard_registration_content0));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_standard_registration_content1));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_standard_registration_content2));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_button_standard_registration_get_started));

            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_myinfo_business, "Register via Myinfo Business"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_myinfo_business_register_time, "Takes 4m"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_myinfo_business_content0, "Keep the following handy:"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_myinfo_business_content1, "Corppass login details"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_myinfo_business_content2, "Singpass login details"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_button_myinfo_business_get_started, "Get Started"));

            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_standard_registration, "Standard Registration"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_standard_registration_register_time, "Takes 10m"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_standard_registration_content0, "Keep the following handy:"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_standard_registration_content1, "Your company UEN"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_standard_registration_content2, "Passport or Identity Card"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_button_standard_registration_get_started, "Get Started"));

        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method VerifyOnboardingPageAllElements | Exception desc : " + e.getMessage());
        }
    }

    // Personal Edit page

    /*
     * Input date of birth
     */
    public void InputDateOfBirth(String dob) {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_input_user_detail_dob);
            getHelper().addTextToElementByJavaScript(onboardingElement.ele_input_user_detail_dob, dob);
//            getHelper().addTextToElementByJavaScript(onboardingElement.ele_input_user_detail_dob, dob);
//            getHelper().findElement(onboardingElement.ele_input_user_detail_dob).sendKeys(dob);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputDateOfBirth | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Nationality
     */
    public void InputNationality(String nationality) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_nationality, nationality);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputNationality | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Gender
     */
    public void InputGender(String gender) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_gender, gender);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputGender | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Personal Edit Form
     */
    public void InputPersonalEditForm(String dob, String nationality, String gender) {
        try {
            InputDateOfBirth(dob);
            InputNationality(nationality);
            InputGender(gender);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputPersonalEditForm | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Onboarding person-edit Page
     */
    public void VerifyOnboardingPersonalEditPageAllElements() {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_icon_user_detail_dob);
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_dob));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_input_user_detail_dob));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_user_detail_nationality));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_nationality));
            Assert.assertTrue(getHelper().isElementPresent(String.format(onboardingElement.ele_input_user_detail_nationality, "false")));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_user_detail_gender));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_gender));
            Assert.assertTrue(getHelper().isElementPresent(String.format(onboardingElement.ele_input_user_detail_gender, "false")));

            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_dob, "Date of birth"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_nationality, "Nationality"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_gender, "Gender"));
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method VerifyOnboardingPageAllElements | Exception desc : " + e.getMessage());
        }
    }

    // Business-edit page

    /*
     * Input Business Legal Name
     */
    public void InputBusinessLegalName(String legalName) {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_icon_user_detail_business_legal_name);
            getHelper().findElement(onboardingElement.ele_icon_user_detail_business_legal_name).sendKeys(legalName);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputBusinessLegalName | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Entity category
     */
    public void InputEntityCategory(String entityCategory) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_entity_category, entityCategory);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputEntityCategory | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Entity Type
     */
    public void InputEntityType(String entityType) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_entity_type, entityType);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputEntityType | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Business registration number (UEN)
     */
    public void InputBusinessRegistrationNumber(String businessRegNumber) {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_input_user_detail_business_reg_number);
            getHelper().findElement(onboardingElement.ele_input_user_detail_business_reg_number).sendKeys(businessRegNumber);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputBusinessRegistrationNumber | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Industry
     */
    public void InputIndustry(String industry) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_industry, industry);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputIndustry | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Sub Industry
     */
    public void InputSubIndustry(String industry) {
        try {
            SelectAspireDropdown(onboardingElement.ele_input_user_detail_sub_industry, industry);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputSubIndustry | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Input Business-edit Form
     */
    public void InputBusinessEditForm(String legalName, String entityCat, String entityType, String businesRegNumber, String industry, String subIndustry) {
        try {
            InputBusinessLegalName(legalName);
            InputEntityCategory(entityCat);
            InputEntityType(entityType);
            InputBusinessRegistrationNumber(businesRegNumber);
            InputIndustry(industry);
            InputSubIndustry(subIndustry);
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method InputBusinessEditForm | Exception desc : " + e.getMessage());
        }
    }

    /*
     * Verify All elements in Onboarding Business-edit Page
     */
    public void VerifyOnboardingBusinessEditPageAllElements() {
        try {
            getHelper().waitForElementVisible(onboardingElement.ele_icon_user_detail_business_legal_name);
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_business_legal_name));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_input_user_detail_business_legal_name));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_user_detail_entity_category));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_entity_category));
            Assert.assertTrue(getHelper().isElementPresent(String.format(onboardingElement.ele_input_user_detail_entity_category, "false")));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_user_detail_business_reg_number));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_business_reg_number));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_input_user_detail_business_reg_number));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_icon_user_detail_industry));
            Assert.assertTrue(getHelper().isElementPresent(onboardingElement.ele_label_user_detail_industry));
            Assert.assertTrue(getHelper().isElementPresent(String.format(onboardingElement.ele_input_user_detail_industry, "false")));

            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_business_legal_name, "Business legal name"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_entity_category, "Entity category"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_business_reg_number, "Business registration number (UEN)"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(onboardingElement.ele_label_user_detail_industry, "Industry"));
        } catch (Exception e) {
            Result.checkFail("Class OnboardingPage | Method VerifyOnboardingPageAllElements | Exception desc : " + e.getMessage());
        }
    }
}
