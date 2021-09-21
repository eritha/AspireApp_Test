package models;

public class BusinessRoleElement extends CommonElement {

    // Open Aspire account
    public String ele_title_open_aspire_account_section = "xpath:::.//div[@class='auth-form__card full-width']/div[1]/div[1]";

    public String ele_account_director_section = "xpath:::.//img[@src='img/auth/director.svg']/parent::div";
    public String ele_icon_account_director = "xpath:::.//img[@src='img/auth/director.svg']";
    public String ele_label_account_director = "xpath:::.//img[@src='img/auth/director.svg']/following-sibling::div";

    public String ele_account_employee_section = "xpath:::.//img[@src='img/auth/employee.svg']/parent::div";
    public String ele_icon_account_employee = "xpath:::.//img[@src='img/auth/employee.svg']";
    public String ele_label_account_employee = "xpath:::.//img[@src='img/auth/employee.svg']/following-sibling::div";

    public String ele_account_freelancer_section = "xpath:::.//img[@src='img/auth/freelancer.svg']/parent::div";
    public String ele_icon_account_freelancer = "xpath:::.//img[@src='img/auth/freelancer.svg']";
    public String ele_label_account_freelancer = "xpath:::.//img[@src='img/auth/freelancer.svg']/following-sibling::div";

    // Incorporate Aspire account
    public String ele_title_incorporate_aspire_account_section = "xpath:::.//div[@class='auth-form__card full-width']/div[2]/div[1]";

    public String ele_account_incorporate_section = "xpath:::.//img[@src='img/auth/incorp.svg']/parent::div";
    public String ele_icon_account_incorporate = "xpath:::.//img[@src='img/auth/incorp.svg']";
    public String ele_label_account_incorporate = "xpath:::.//img[@src='img/auth/incorp.svg']/following-sibling::div";
}
