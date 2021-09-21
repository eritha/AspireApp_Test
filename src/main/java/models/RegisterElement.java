package models;

public class RegisterElement {

    public String ele_label_full_name = "xpath:::.//img[@src='img/common/labels/user.svg']/following-sibling::div";
    public String ele_icon_full_name = "xpath:::.//img[@src='img/common/labels/user.svg']";
    public String ele_input_full_name = "xpath:::.//input[@name='full_name']";
    public String ele_icon_full_name_error = "xpath:::.//div[@name='full_name']//img";
    public String ele_label_full_name_error = "xpath:::.//div[@name='full_name']//div[@class='aspire-label__text text-negative']";

    public String ele_label_preferred_name = "xpath:::.//img[@src='img/common/labels/preferred-name.svg']/following-sibling::div";
    public String ele_icon_preferred_name = "xpath:::.//img[@src='img/common/labels/preferred-name.svg']";
    public String ele_input_preferred_name = "xpath:::.//input[@name='preferred_name']";

    public String ele_label_email = "xpath:::.//img[@src='img/common/labels/email.svg']/following-sibling::div";
    public String ele_icon_email = "xpath:::.//img[@src='img/common/labels/email.svg']";
    public String ele_input_email = "xpath:::.//input[@name='email']";
    public String ele_icon_email_error = "xpath:::.//div[@type='email']//img";
    public String ele_label_email_error = "xpath:::.//div[@type='email']//div[@class='aspire-label__text text-negative']";

    public String ele_label_phone = "xpath:::.//img[@src='img/common/labels/phone.svg']/following-sibling::div";
    public String ele_icon_phone = "xpath:::.//img[@src='img/common/labels/phone.svg']";
    public String ele_input_phone = "xpath:::.//input[@name='phone']";
    public String ele_icon_phone_error = "xpath:::.//div[@name='phone']//img";
    public String ele_label_phone_error = "xpath:::.//div[@name='phone']//div[@class='aspire-label__text text-negative']";

    public String ele_cbx_phone = "xpath:::.//div[@role='combobox'][@aria-expanded='%s']"; // true/false
    public String ele_listbox_value = "xpath:::.//div[@role='listbox']//div[@class='q-item__label'][text()='%s']"; //Viet Nam (+84)

    //    public String ele_cbx_phone_expanded = "xpath:::.//div[@role='combobox'][@aria-expanded='true']";
    public String ele_label_heard_about = "xpath:::.//img[@src='img/auth/heard-about.svg']/following-sibling::div";
    public String ele_icon_heard_about = "xpath:::.//img[@src='img/auth/heard-about.svg']";
    public String ele_input_heard_about = "xpath:::.//input[@type='search'][@aria-expanded='%s']"; // true/false

    public String ele_label_referral_code = "xpath:::.//img[@src='img/common/labels/coupon.svg']/following-sibling::div";
    public String ele_icon_referral_code = "xpath:::.//img[@src='img/common/labels/coupon.svg']";
    public String ele_input_referral_code = "xpath:::.//input[@icon-url='img/common/labels/coupon.svg']";
    public String ele_btn_apply_referral_code = "xpath::://input[@icon-url='img/common/labels/coupon.svg']/parent::div/following-sibling::div/button";
    public String ele_icon_referral_code_applied = "xpath:::.//img[@src='img/common/check-no-bg.svg']";

    public String ele_ckb_agreement = "xpath:::.//div[@role='checkbox']";
    public String ele_label_agreement = "xpath:::.//div[@role='checkbox']/following-sibling::div";

    public String ele_label_already_registered = "xpath:::.//div[@class='register-step-person__login text-center']";
    public String ele_link_login = "xpath:::.//div[@class='register-step-person__login text-center']/span";
}
