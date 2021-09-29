package Pages;

import Maps.IfoodCadastroMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IfoodCadastroPage {
    WebDriver driver;
    IfoodCadastroMap ifoodCadastroMap;

    public IfoodCadastroPage(WebDriver driver) {
        this.driver = driver;
        ifoodCadastroMap = new IfoodCadastroMap();
        PageFactory.initElements(driver, ifoodCadastroMap);
    }

    public void fillForm(){
        ifoodCadastroMap.name.sendKeys("Rogério Carvalho");
        ifoodCadastroMap.tel.sendKeys("21982536536");
        ifoodCadastroMap.email.sendKeys("asdytcdiduf@gmail.com");
        ifoodCadastroMap.nameEmp.sendKeys("Auth Foods");
        ifoodCadastroMap.employees.sendKeys("25");
        ifoodCadastroMap.cnpj.sendKeys("27068131000167");
        ifoodCadastroMap.ddMenuOptionS.click();
    }

    public void sendForm(){
        ifoodCadastroMap.send.click();
    }

    public List<WebElement> getTYPMessage(){
        return ifoodCadastroMap.messageTYP;
    }
}
