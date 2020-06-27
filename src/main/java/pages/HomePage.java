package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy (id="temperature")
    WebElement temp;

    @FindBy(linkText = "Buy moisturizers")
    WebElement moisturizers;

    @FindBy(linkText = "Buy sunscreens")
    WebElement sunscreens;

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getCurrentTemp()
    {
        return temp.getText();
    }

    public buyMoisturizersPage BuyMoisturizers()
    {
        moisturizers.click();
        return new buyMoisturizersPage();
    }

    public buySunscreensPage BuySunscreens()
    {
        sunscreens.click();
        return new buySunscreensPage();
    }


}
