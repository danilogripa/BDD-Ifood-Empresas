package Maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IfoodCadastroMap {
    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "tel")
    public WebElement tel;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "name-emp")
    public WebElement nameEmp;

    @FindBy(name = "employees")
    public WebElement employees;

    @FindBy(name = "cnpj")
    public WebElement cnpj;

    @FindBy(xpath = "//*[@id=\"option1-hero\"]") //Dropdowm Menu Option 1
    public WebElement ddMenuOptionS;

    @FindBy(css = ".contact-form-submit")
    public WebElement send;

    @FindBy(css = ".contact-return-title")
    public List<WebElement> messageTYP;

}
