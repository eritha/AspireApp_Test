package models;

public class OnboardingElement extends CommonElement {

    public String ele_label_myinfo_business = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@class='text-bold q-mr-sm']";
    public String ele_icon_myinfo_business = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@role='img']";
    public String ele_label_myinfo_business_register_time = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@class='q-chip__content col row no-wrap items-center q-anchor--skip']";
    public String ele_label_myinfo_business_content0 = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@class='q-mt-sm onboarding-step-register-select-method__steps-label']";
    public String ele_label_myinfo_business_content1 = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@class='q-item q-item-type row no-wrap q-pa-none']";
    public String ele_label_myinfo_business_content2 = "xpath:::.//div[@class='auth-form__card']/div[1]//div[@class='q-item q-item-type row no-wrap q-pa-none q-mt-sm']";
    public String ele_button_myinfo_business_get_started = "xpath:::.//div[@class='auth-form__card']/div[1]//button";

    public String ele_label_standard_registration = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@class='text-bold q-mr-sm']";
    public String ele_icon_standard_registration = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@role='img']";
    public String ele_label_standard_registration_register_time = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@class='q-chip__content col row no-wrap items-center q-anchor--skip']";
    public String ele_label_standard_registration_content0 = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@class='q-mt-sm onboarding-step-register-select-method__steps-label']";
    public String ele_label_standard_registration_content1 = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@class='q-item q-item-type row no-wrap q-pa-none']";
    public String ele_label_standard_registration_content2 = "xpath:::.//div[@class='auth-form__card']/div[2]//div[@class='q-item q-item-type row no-wrap q-pa-none q-mt-sm']";
    public String ele_button_standard_registration_get_started = "xpath:::.//div[@class='auth-form__card']/div[2]//button";

    // onboarding/person-edit
    public String ele_icon_user_detail_dob = "xpath:::.//img[@src='img/common/labels/calendar.svg']";
    public String ele_label_user_detail_dob = "xpath:::.//img[@src='img/common/labels/calendar.svg']/following-sibling::div";
    public String ele_input_user_detail_dob = "xpath:::.//input[@iconurl='img/common/labels/calendar.svg']";  // Dec 10, 1988

    public String ele_icon_user_detail_nationality = "xpath:::.//img[@src='img/kyc/nationality.svg']";
    public String ele_label_user_detail_nationality = "xpath:::.//img[@src='img/kyc/nationality.svg']/following-sibling::div";
    public String ele_input_user_detail_nationality = "xpath::://div[@icon-url='img/kyc/nationality.svg']/input[@role='combobox'][@aria-expanded='%s']";

    public String ele_icon_user_detail_gender = "xpath:::.//img[@src='img/kyc/gender.svg']";
    public String ele_label_user_detail_gender = "xpath:::.//img[@src='img/kyc/gender.svg']/following-sibling::div";
    public String ele_input_user_detail_gender = "xpath:::.//div[@icon-url='img/kyc/gender.svg']/input[@role='combobox'][@aria-expanded='%s']";


    // onboarding/business-edit
    public String ele_icon_user_detail_business_legal_name = "xpath:::.//img[@src='img/kyc/business-name.svg']";
    public String ele_label_user_detail_business_legal_name = "xpath:::.//img[@src='img/kyc/business-name.svg']/following-sibling::div";
    public String ele_input_user_detail_business_legal_name = "xpath:::.//input[@icon-url='img/kyc/business-name.svg']";

    public String ele_icon_user_detail_entity_category = "xpath:::.//img[@src='img/kyc/business-parent-reg-type.svg']";
    public String ele_label_user_detail_entity_category = "xpath:::.//img[@src='img/kyc/business-parent-reg-type.svg']/following-sibling::div";
    public String ele_input_user_detail_entity_category = "xpath:::.//div[@icon-url='img/kyc/business-parent-reg-type.svg']/input[@type='search'][@aria-expanded='%s']";

    public String ele_icon_user_detail_entity_type = "xpath:::.//img[@src='img/kyc/business-reg-type.svg']";
    public String ele_label_user_detail_entity_type = "xpath:::.//img[@src='img/kyc/business-reg-type.svg']/following-sibling::div";
    public String ele_input_user_detail_entity_type = "xpath:::.//div[@icon-url='img/kyc/business-reg-type.svg']/div[@aria-expanded='%s']";

    public String ele_icon_user_detail_business_reg_number = "xpath:::.//img[@src='img/common/labels/document.svg']";
    public String ele_label_user_detail_business_reg_number = "xpath:::.//img[@src='img/common/labels/document.svg']/following-sibling::div";
    public String ele_input_user_detail_business_reg_number = "xpath:::.//input[@icon-url='img/common/labels/document.svg']";

    public String ele_icon_user_detail_industry = "xpath:::.//img[@src='img/kyc/business-industry.svg']";
    public String ele_label_user_detail_industry = "xpath:::.//img[@src='img/kyc/business-industry.svg']/following-sibling::div";
    public String ele_input_user_detail_industry = "xpath:::.//div[@icon-url='img/kyc/business-industry.svg']/input[@type='search'][@aria-expanded='%s']";

    public String ele_icon_user_detail_sub_industry = "xpath:::.//img[@src='img/kyc/business-sub-industry.svg']";
    public String ele_label_user_detail_sub_industry = "xpath:::.//img[@src='img/kyc/business-sub-industry.svg']/following-sibling::div";
    public String ele_input_user_detail_sub_industry = "xpath:::.//div[@icon-url='img/kyc/business-sub-industry.svg']/input[@type='search'][@aria-expanded='%s']";
}
