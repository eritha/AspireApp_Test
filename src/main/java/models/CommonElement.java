package models;

public class CommonElement {
    public String ele_icon_back = "xpath:::.//img[@src='img/common/arrows/back-primary.svg']/parent::div";
    public String ele_listbox_value = "xpath:::.//div[@role='listbox']//div[contains(@class,'q-item__label')][text()='%s']";
    public String ele_btn_submit_continue = "xpath:::.//button[@position='bottom-right']";
}
