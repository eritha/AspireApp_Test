package models;

public class MobileOtpElement extends CommonElement {
    public String ele_label_opt_message = "xpath:::.//div[@class='verify-otp-form__content q-mb-md']";
//    public String ele_btn_opt_change_phone_number = "xpath:::.//div[@class='flex justify-center']//button";

    public String ele_otp_input_section = "xpath:::.//div[@class='verify-otp-form__input flex flex-center']";
    public String ele_input_otp = "xpath:::.//input[@inputmode='numeric']";
    public String ele_input_otp_value = "xpath:::.//input[@inputmode='numeric']//following-sibling::div/div[%s]";
//    public String ele_input_otp_value = "xpath:::.//div[contains(@class,'digit-input__input--highlight')]";

    public String ele_btn_opt_resend = "xpath:::.//form/button";
}
