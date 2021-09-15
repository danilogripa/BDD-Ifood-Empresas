package IfoodTest;

// Importa as bibliotecas do JUnit, Selenium WebDriver, List etc.

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

// Classe JUnit que contém os métodos de teste.
public class IfoodTest {

    // Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;

    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página inicial da DevMedia.
    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://empresas.ifood.com.br/ifood-beneficios");
        driver.get("https://englishlive.ef.com/pt-br/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.
    @AfterClass
    public static void tearDownTest(){
        //try{Thread.sleep(10000);}catch(InterruptedException ie){}
        driver.quit();
    }

    // Testa título "DevMedia - Cursos, Tutoriais e Vídeos para Desenvolvedores".
    @Test
    public void testaTituloDaPagina(){
        assertEquals("iFood Benefícios – Vale-Alimentação e Vale-Refeição", driver.getTitle());
    }

    // Método que testa o login no site DevMedia.
    @Test
    public void testaLoginDevMedia() {

        //try{Thread.sleep(8000);}catch(InterruptedException ie){}
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Preenche o Nome
        WebElement element = driver.findElement(By.name("name"));
        //driver.switchTo().frame(element);
        //element.sendKeys("Paulo Soares");

        element = driver.findElement(By.tagName("form"));

        // Get all the elements available with tag name 'p'
        List<WebElement> elements = element.findElements(By.tagName("input"));
        for (WebElement e : elements) {
            System.out.println(e.getAttribute("name"));
            //if (e.getAttribute("name") == "name"){e.click(); e.sendKeys("Paulo Soares");}
            if (e.getAttribute("name") == "tel"){ e.sendKeys("21982320878");}
            if (e.getAttribute("name") == "email"){ e.sendKeys("paulo@gmail.com");}
            if (e.getAttribute("name") == "name-emp"){ e.sendKeys("Fantastic Food SA");}
            if (e.getAttribute("name") == "employees"){ e.sendKeys("34");}
            if (e.getAttribute("name") == "cnpj"){ e.sendKeys("27068131000167");}
        }


        driver.switchTo().defaultContent();

        //element.findElement(By.className("nld-close-white")).click();

        //Preenche o Telefone
        element.findElement(By.name("tel"));
        element.sendKeys("21987686756");

        //Preenche o Email
        element.findElement(By.name("email")).click();
        element.sendKeys("paulosoares@gmail.com");

        //Preenche o Nome da Empresa
        element.findElement(By.name("name_emp")).click();
        element.sendKeys("Fantastic Food SA");

        //Preenche o Numeros de Funcionarios
        element.findElement(By.name("employees")).click();
        element.sendKeys("45");

        //Preenche o CNPJ
        element.findElement(By.name("cnpj")).click();
        element.sendKeys("27068131000167");


        element = driver.findElement(By.name("delivery"));
        Select selectObject = new Select(element);
        selectObject.selectByValue("yes");



        // Insere dados no elemento "usuario".
        //element.sendKeys("user@devmedia.com.br");

        // Atribui ao objeto “element” o elemento de atributo "name" igual a "senha".
        //element = driver.findElement(By.name("senha"));

        // Insere dados no elemento "senha".
        //element.sendKeys("123456");

        // Clica no botão "OK" e submete os dados para concluir o login.
        //driver.findElement(By.id("imglogar")).click();
    }
}