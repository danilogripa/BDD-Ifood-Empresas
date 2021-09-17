package IfoodTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DriverUtilities {
    public static WebDriver driver;
    public static String fileName;
    public static String webSiteName;

    private static final String webDrivePath = "C:\\libs\\chromedriver.exe";


    public static void print(WebDriver driver, String step){
        DriverUtilities.driver = driver;
        fileName = getFileName(step);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sleep5S() {
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ie){}
    }

    public static WebDriver setUp(String websiteName) {
        webSiteName = websiteName;
        System.setProperty("webdriver.chrome.driver", webDrivePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static String getFileName(String step) {
        fileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm'.png'").format(new Date());
        fileName = "./img - " + step + " - " + webSiteName + " - " + fileName;
        return fileName;
    }

    public static void assertFinalPage(WebDriver driver, String cssSelector){
        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
        assert(elements.size() > 0);
    }

    public static void selectDDMenu(WebDriver driver, String id, String xpath){
        WebElement dropdown = driver.findElement(By.id(id));
        dropdown.findElement(By.xpath(xpath)).click();
    }

}
