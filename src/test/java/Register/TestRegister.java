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

package Register;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.*;
import utility.LogUtils;

import java.lang.reflect.Method;

import static utility.PropertiesUtils.*;


public class TestRegister extends BaseTest {
    String className = this.getClass().getSimpleName();
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private OtpPage otpPage;
    private RegisterCompletedPage registerCompletedPage;
    private BusinessRolePage businessRolePage;
    private AdditionalDetailsPage additionalDetailsPage;
    private OnboardingPage onboardingPage;
    private UnincorporatedPage unincorporatedPage;
    private IncorporatedPage incorporatedPage;
    private DialogAccountExists dialogAccountExists;

    String testCaseName;

    @BeforeMethod
    public void setUp(Method method) {
        super.setUp(aspireUrl);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        otpPage = new OtpPage(driver);
        registerCompletedPage = new RegisterCompletedPage(driver);
        businessRolePage = new BusinessRolePage(driver);
        additionalDetailsPage = new AdditionalDetailsPage(driver);
        onboardingPage = new OnboardingPage(driver);
        unincorporatedPage = new UnincorporatedPage(driver);
        incorporatedPage = new IncorporatedPage(driver);
        dialogAccountExists = new DialogAccountExists(driver);
        LogUtils.info("------------------------------Test Register -----------------------------");
        test = extent.startTest(method.getName()).assignCategory(
                getClass().getSimpleName());
    }

    /*
     * SCENARIO: TC001_VerifyNewAccountCreatedSuccessfullyAndIncorporated
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid info & submit (Singapore)
     * #5: Verify user created successful
     * #6: Click continue button to go business page
     * #7: Select new account as director and click continue
     * #8: Select more personal information details (Singapore)
     * #9: Verify the Onboarding page shown successfully
     * #10: Click button "Get Started" for Standard registration
     * #11: Verify the Personal detail and input more info, then click continue
     * #12: Verify the Business info and input valid date, then click continue
     * #13: => I will ignore next steps for the onboarding with the KYC of Singapore
     */
    @Test
    public void REG_001_VerifyNewAccountCreatedSuccessfullyAndIncorporated() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
        String phoneNumber = "9" + getHelper().randomNumber(8);
        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", emailAddress, "Singapore (+65)", phoneNumber, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");

        registerCompletedPage.VerifyRegisterNewAccountSuccessfully();
        registerCompletedPage.ClickButtonContinue();

        businessRolePage.VerifyTheBusinessPageShouldBeDisplayed();
        businessRolePage.SelectToOpenNewAccountAsDirector();

        String[] solutions = {"numquam", "iste", "saepe"};
        additionalDetailsPage.VerifyAdditionalDetailsPageAllElements();
        additionalDetailsPage.InputAdditionalDetailsForm("Singapore", true, solutions);
        additionalDetailsPage.ClickButtonContinue();

        // Verify Onboarding page shown
        onboardingPage.VerifyOnboardingPageAllElements();
        onboardingPage.ClickButtonGetStartedStandardRegistration();

        onboardingPage.VerifyOnboardingPersonalEditPageAllElements();
        onboardingPage.InputPersonalEditForm("Dec 10, 1988", "Angola", "Male");
    }

    /*
     * SCENARIO: REG_002_VerifyNewAccountUnincorporatedCountryForDirector
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid info & submit (VietNam)
     * #5: Verify user created successful
     * #6: Click continue button to go business page
     * #7: Select new account as director and click continue
     * #8: Select more additional information details like company registered (Angola)
     * #9: Verify the business unincorporated in Angola
     */
    @Test
    public void REG_002_VerifyNewAccountUnincorporatedCountryForDirector() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
        String phoneNumber = "9" + getHelper().randomNumber(8);
        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", emailAddress, "Viet Nam (+84)", phoneNumber, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");

        registerCompletedPage.VerifyRegisterNewAccountSuccessfully();
        registerCompletedPage.ClickButtonContinue();

        businessRolePage.VerifyTheBusinessPageShouldBeDisplayed();
        businessRolePage.SelectToOpenNewAccountAsDirector();

        String[] solutions = {"numquam", "iste", "saepe"};
        additionalDetailsPage.VerifyAdditionalDetailsPageAllElements();
        additionalDetailsPage.InputAdditionalDetailsForm("Angola", true, solutions);
        additionalDetailsPage.ClickButtonContinue();

        // Verify unincorporated in "Angola"
        unincorporatedPage.VerifyUnincorporatedPageAllElements("Angola");
    }

    /*
     * SCENARIO: REG_003_VerifyNewAccountUnincorporatedCountryForNonEmployee
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid info & submit (VietNam)
     * #5: Verify user created successful
     * #6: Click continue button to go business page
     * #7: Select new account as non director and click continue
     * #8: Select more additional information details like company registered (Angola)
     * #9: Verify the business unincorporated in Angola
     */
    @Test
    public void REG_003_VerifyNewAccountUnincorporatedCountryForNonEmployee() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
        String phoneNumber = "9" + getHelper().randomNumber(8);
        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", emailAddress, "Viet Nam (+84)", phoneNumber, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");

        registerCompletedPage.VerifyRegisterNewAccountSuccessfully();
        registerCompletedPage.ClickButtonContinue();

        businessRolePage.VerifyTheBusinessPageShouldBeDisplayed();
        businessRolePage.SelectToOpenNewAccountAsNonDirector();
    }

    /*
     * SCENARIO: REG_004_VerifyNewAccountUnincorporatedCountryForFreelancer
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid info & submit (VietNam)
     * #5: Verify user created successful
     * #6: Click continue button to go business page
     * #7: Select new account as freelancer and click continue
     * #8: Select more additional information details like company registered (Angola)
     * #9: Verify the business unincorporated in Angola
     */
    @Test
    public void REG_004_VerifyNewAccountUnincorporatedCountryForFreelancer() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
        String phoneNumber = "9" + getHelper().randomNumber(8);
        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", emailAddress, "Viet Nam (+84)", phoneNumber, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");

        registerCompletedPage.VerifyRegisterNewAccountSuccessfully();
        registerCompletedPage.ClickButtonContinue();

        businessRolePage.VerifyTheBusinessPageShouldBeDisplayed();
        businessRolePage.SelectToOpenNewAccountAsFreelancer();
    }

    /*
     * SCENARIO: REG_005_VerifyNewAccountCreatedForIncorporateMyCompany
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid info & submit (VietNam)
     * #5: Verify user created successful
     * #6: Click continue button to go business page
     * #7: Select new account To Incorporate My Company and click continue
     * #8: Verify the Aspire Incorporated page should be displayed
     */
    @Test
    public void REG_005_VerifyNewAccountCreatedForIncorporateMyCompany() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        String emailAddress = "user" + System.currentTimeMillis() + "@yopmail.com";
        String phoneNumber = "9" + getHelper().randomNumber(8);
        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", emailAddress, "Viet Nam (+84)", phoneNumber, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        otpPage.VerifyOtpPageAllElements();
        otpPage.InputOtp("1234");

        registerCompletedPage.VerifyRegisterNewAccountSuccessfully();
        registerCompletedPage.ClickButtonContinue();

        businessRolePage.VerifyTheBusinessPageShouldBeDisplayed();
        businessRolePage.SelectToOpenNewToIncorporateMyCompany();

        // Verify Incorporated
        incorporatedPage.VerifyAspireIncorporatedPageAllElements();
    }

    /*
     * SCENARIO: REG_006_VerifyNewAccountRegisterIsExistedAndAssociated
     * Precondition: An email valid
     * #1: Goes to aspire login page
     * #2: Click register link
     * #3: Verify UI of Register page
     * #4: Input valid phone number "+65937892009" and email "erit09@gmail.com"
     * #5: Dialog confirm the account associated should be display
     * #6: Close the dialog
     */
    @Test
    public void REG_006_VerifyNewAccountRegisterIsExistedAndAssociated() throws InterruptedException {
        testCaseName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        super.startRecordVideoAfterMethod(className, testCaseName);

        loginPage.VerifyLoginPageAllElements();
        loginPage.ClickLinkRegister();
        Thread.sleep(1000); // Issue lazy load at register page

        registerPage.VerifyRegisterPageAllElements();
        registerPage.InputRegisterForm("Phuoc Ha", "Erit", accountEmail, "Singapore (+65)", accountPhone, "Google", "");
        registerPage.ClickCheckboxTermsAndConditions();
        registerPage.ClickButtonContinue();

        dialogAccountExists.VerifyDialogAccountexistsAllElements(accountEmail, accountPhone);
        dialogAccountExists.ClickButtonCloseDialog();

        registerPage.PageShouldShowTheEmailErrorMessage("The email has already been taken.");
        registerPage.PageShouldShowThePhoneNumberErrorMessage("The phone has already been taken.");
    }

    @AfterMethod
    public void tearDown() {
        Constants.sClassName = className;
        super.stopRecordVideoAfterMethod();
        super.screenShotAfterMethod(className, testCaseName);
        super.afterMethod();
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}
