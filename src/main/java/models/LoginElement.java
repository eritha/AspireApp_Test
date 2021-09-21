package models;

public class LoginElement extends CommonElement {

    public String ele_label_user_login = "xpath:::.//img[@src='img/common/labels/user.svg']/following-sibling::div";
    public String ele_icon_user_login = "xpath:::.//img[@src='img/common/labels/user.svg']";
    public String ele_input_user_login = "xpath:::.//input[@name='username']";
    public String ele_label_user_error_msg = "xpath:::.//img[@src='img/common/error.svg']/following-sibling::div";

    public String ele_ckb_remember_me = "xpath:::.//div[@role='checkbox']";
    public String ele_ckb_label_remember_me = "xpath:::.//div[@role='checkbox']//div[@class='q-checkbox__label q-anchor--skip']";

    public String ele_label_dont_have_account = "xpath:::.//div[@class='login-step-start__register']";
    public String ele_link_register = "xpath:::.//div[@class='login-step-start__register']/a";

    public String ele_btn_next = "xpath:::.//button[@position='bottom-right']";

}