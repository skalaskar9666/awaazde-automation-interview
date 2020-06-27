package Testcases;

import Base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cart;
import pages.HomePage;
import pages.buyMoisturizersPage;
import pages.buySunscreensPage;

public class HomePageTest extends TestBase {

    HomePage homePage;

    buyMoisturizersPage moistpage;
    buySunscreensPage sunscreenspage;
    Cart cart;


    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialize();
        homePage = new HomePage();
    }

    @Test
    public void checkTemp()
    {
        String currentTemp = homePage.getCurrentTemp();
        System.out.println("Current Temperature is :"+currentTemp);
        int temparature =Integer.valueOf(currentTemp.split(" ")[0]);
        if(temparature < 19)
        {
            moistpage = homePage.BuyMoisturizers();
            System.out.println(moistpage.getTitle());
            moistpage.getMoisturizers();
            cart = moistpage.clickCart();
            cart.payMent();


        }
        else if (temparature >34)
        {
            sunscreenspage = homePage.BuySunscreens();
            System.out.println(sunscreenspage.getTitle());
            sunscreenspage.getSunscreens();
            cart= sunscreenspage.clickCart();
            cart.payMent();


        }
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
