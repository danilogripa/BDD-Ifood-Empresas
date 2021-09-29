package Test;

import Core.Driver;
import Pages.IfoodCadastroPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class IfoodCadastroTest {
    public String websiteName = "Ifood";
    public String websiteLink = "https://empresas.ifood.com.br/ifood-beneficios";

    WebDriver webDriver;    //Selenium Driver
    Driver driver;          //My driver

    IfoodCadastroPage ifoodCadastroPage;

    @Before
    public void setUp() {
        driver = new Driver("chrome", websiteName);
        webDriver = driver.getDriver();
        webDriver.get(websiteLink);
        ifoodCadastroPage = new IfoodCadastroPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testDeCadastro() {

        // 1 | Fill the Registration Form |
        ifoodCadastroPage.fillForm();

        // 2 | Print |
        driver.print("Dados");

        // 3 | Send |
        ifoodCadastroPage.sendForm();

        // 4 | Wait 5 Secs |
        driver.sleep5S();

        // 5 | Assert |
        Assert.assertTrue(ifoodCadastroPage.getTYPMessage().size() > 0);

        // 6 | Print Thank You Page |
        driver.print("Final");
    }

}
