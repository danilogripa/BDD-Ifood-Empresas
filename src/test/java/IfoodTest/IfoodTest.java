package IfoodTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IfoodTest {
    public String websiteName = "Ifood";
    public String websiteLink = "https://empresas.ifood.com.br/ifood-beneficios";

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverUtilities.setUp(websiteName);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDeCadastro() {

        // 1 | open | Website |
        driver.get(websiteLink);

        // 2 | type | Name |
        driver.findElement(By.name("name")).sendKeys("Rogério Carvalho ");

        // 3 | type | Phone |
        driver.findElement(By.name("tel")).sendKeys("21982536536");

        // 4 | type | Email |
        driver.findElement(By.name("email")).sendKeys("asdytcdiduf@gmail.com");

        // 5 | type | Company Name |
        driver.findElement(By.name("name-emp")).sendKeys("Auth Foods");

        // 6 | type | N of Employees |
        driver.findElement(By.name("employees")).sendKeys("25");

        // 7 | type | CNPJ |
        driver.findElement(By.name("cnpj")).sendKeys("27068131000167");

        // 8 | Select DropDown Menu | is delivery? |
        DriverUtilities.selectDDMenu(driver, "delivery-option", "//option[. = 'Sim']");

        // 9 | Print | Data |
        DriverUtilities.print(driver, "Dados");

        // 10 | Click | Send |
        driver.findElement(By.cssSelector(".contact-form-submit")).click();

        // 11 | Wait 5 Secs | Page Update |
        DriverUtilities.sleep5S();

        // 12 | Assert | Thank You Page |
        DriverUtilities.assertFinalPage(driver, ".contact-return-title");

        // 13 | Print | Thank You Page |
        DriverUtilities.print(driver, "Final");
    }
}
