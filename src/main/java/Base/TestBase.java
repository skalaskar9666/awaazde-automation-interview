package Base;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    public TestBase()
    {
        try{
            prop = new Properties();
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Configuration/config.properties");
            prop.load(fi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialize()
    {
        if(OS.isFamilyMac())
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
        }
        else
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        }
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
