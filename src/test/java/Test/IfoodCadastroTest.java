package Test;

import Core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IfoodCadastroTest {
    public String websiteName = "Ifood";
    public String websiteLink = "https://empresas.ifood.com.br/ifood-beneficios";

    WebDriver webDriver;    //Selenium Driver
    Driver driver;          //My driver

    @Before
    public void setUp() {
        driver = new Driver("chrome", websiteName);
        webDriver = driver.getDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testDeCadastro() {

        // 1 | open | Website |
        webDriver.get(websiteLink);

        // 2 | type | Name |
        webDriver.findElement(By.name("name")).sendKeys("Rogério Carvalho");

        // 3 | type | Phone |
        webDriver.findElement(By.name("tel")).sendKeys("21982536536");

        // 4 | type | Email |
        webDriver.findElement(By.name("email")).sendKeys("asdytcdiduf@gmail.com");

        // 5 | type | Company Name |
        webDriver.findElement(By.name("name-emp")).sendKeys("Auth Foods");

        // 6 | type | N of Employees |
        webDriver.findElement(By.name("employees")).sendKeys("25");

        // 7 | type | CNPJ |
        webDriver.findElement(By.name("cnpj")).sendKeys("27068131000167");

        // 8 | Select DropDown Menu | is delivery? |
        driver.selectDDMenu("delivery-option", "//option[. = 'Sim']");

        // 9 | Print | Data |
        driver.print("Dados");

        // 10 | Click | Send |
        webDriver.findElement(By.cssSelector(".contact-form-submit")).click();

        // 11 | Wait 5 Secs | Page Update |
        driver.sleep5S();

        // 12 | Assert | Thank You Page |
        driver.assertFinalPage(".contact-return-title");

        // 13 | Print | Thank You Page |
        driver.print("Final");
    }
}
