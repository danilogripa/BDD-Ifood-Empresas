package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
    WebDriver driver;
    String fileName;
    String webSiteName;

    public Driver(String navegador, String websiteName) {
        webSiteName = websiteName;
        switch (navegador){
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }


    public void print(String step){
        fileName = getFileName(step);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sleep5S() {
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ie){
        }
    }


    public String getFileName(String step) {
        fileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm'.png'").format(new Date());
        fileName = "./img - " + step + " - " + webSiteName + " - " + fileName;
        return fileName;
    }
}
