package models;

public class DialogCountryCodeElement {

    public String ele_label_dialog_title = "xpath:::.//div[contains(@class,'q-dialog')]//div[contains(@class,'dial-code-select-modal__title')]";
    public String ele_label_dialog_sub_title = "xpath:::.//div[contains(@class,'q-dialog')]//div[contains(@class,'dial-code-select-modal__subtitle')]";
    public String ele_icon_dialog_registered_mobile_num = "xpath:::.//img[@src='img/common/labels/phone.svg']";
    public String ele_label_dialog_registered_mobile_num = "xpath:::.//img[@src='img/common/labels/phone.svg']/following-sibling::div";

    public String ele_input_registered_phone_number = "xpath:::.//div[contains(@class,'q-dialog')]//input[@name='phone']";
    public String ele_cbx_phone = "xpath:::.//div[@role='combobox'][@aria-expanded='%s']";

    public String ele_button_next = "xpath:::.//div[contains(@class,'q-dialog')]//button";

}