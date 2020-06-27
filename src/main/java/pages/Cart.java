package pages;

import Base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cart extends TestBase {

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/button/span")
    WebElement paybtn;

    public Cart()
    {
        PageFactory.initElements(driver,this);
    }

    public void payMent()

    {
        paybtn.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(prop.getProperty("email"));
        driver.findElement(By.xpath("//input[@placeholder='Card number']")).sendKeys(prop.getProperty("ccn"));
        driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys(prop.getProperty("mm/yy"));
        driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys(prop.getProperty("cvc"));
        driver.findElement(By.xpath("//input[@placeholder='ZIP Code']")).sendKeys(prop.getProperty("zip"));
        driver.findElement(By.tagName("button")).click();


        WebDriverWait wait = new WebDriverWait(driver,30);

        String status = driver.findElement(By.tagName("h2")).getText();
        if(status.contains("SUCCESS"))
        {
            System.out.println("Payment is success");
        }
        else
            System.out.println("Failure");




    }
}
