package models;

public class AdditionalDetailsElement extends CommonElement {

    public String ele_label_user_detail_nationality = "xpath:::.//div[@url='countries/all']/div[1]/div[@class='aspire-label__text']"; // Where is your company registered?
    public String ele_icon_user_detail_nationality = "xpath:::.//div[@url='countries/all']/div[1]/img[@src='img/kyc/nationality.svg']";
    public String ele_dropdown_user_detail_nationality = "xpath:::.//div[@icon-url='img/kyc/nationality.svg']//*[@role='combobox'][@aria-expanded='%s']";
//    public String ele_listbox_value = "xpath:::.//div[@role='listbox']//div[contains(@class,'q-item__label')][text()='%s']"; // Viet Nam

    public String ele_ckb_company_not_register = "xpath:::.//div[@role='checkbox']";
    public String ele_label_company_not_register = "xpath:::.//div[@role='checkbox']//div[@class='q-checkbox__label q-anchor--skip']"; // My company is not registered yet

    public String ele_icon_user_detail_search = "xpath:::.//img[@src='img/common/search.svg']";
    public String ele_label_user_detail_search = "xpath:::.//img[@src='img/common/search.svg']/following-sibling::div";
    public String ele_dropdown_user_detail_search = "xpath:::.//div[@icon-url='img/common/search.svg']/*[@role='combobox'][@aria-expanded='%s']";

}
