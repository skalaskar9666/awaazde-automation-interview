package pages;

import Base.Property;
import Base.PropertyCompare;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class buySunscreensPage extends TestBase {


@FindBy(xpath = "/html/body/nav/ul/button")
WebElement clickcart;

    public buySunscreensPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void getSunscreens()
    {
        List<WebElement> ele = driver.findElements(By.tagName("p"));
        int count = 0;
        List<String> nameList = new ArrayList<String>();
        List<Integer> priceList = new ArrayList<Integer>();


        for(WebElement element: ele)
        {
            if(count%2 ==0)
            {
                nameList.add(element.getText());
            }
            else
            {
                int price = 0;
                if (element.getText().contains("Rs"))
                {
                    price = Integer.valueOf(element.getText().split("Price: Rs. ")[1]);
                }
                else
                {
                    price = Integer.valueOf(element.getText().split("Price: ")[1]);
                }
                priceList.add(price);
            }

            count++;
        }
        System.out.println("Name: "+nameList.toString());
        System.out.println("Price: "+priceList.toString());
        System.out.println("*******************()");


        int tcount = 0;
        Property property = null;
        List<Property> propertyListspf50 = new ArrayList<Property>();
        List<Property> propertyListspf30 = new ArrayList<Property>();

        for(String name: nameList)
        {
            if (name.contains("SPF-50"))
            {
                property = new Property(name,priceList.get(tcount));
                propertyListspf50.add(property);
            }
            else if (name.contains("SPF-30"))
            {
                property = new Property(name,priceList.get(tcount));
                propertyListspf30.add(property);
            }

            tcount++;
        }



        Collections.sort(propertyListspf30,new PropertyCompare());
        Collections.sort(propertyListspf50,new PropertyCompare());


        System.out.println(propertyListspf30.get(0).getName());
        System.out.println(propertyListspf30.get(0).getPrice());
        List<WebElement> spf30 = driver.findElements(By.tagName("button"));
        if (!propertyListspf30.isEmpty()) {
            for (WebElement elem : spf30) {
                if (elem.getAttribute("onclick").contains(propertyListspf30.get(0).getName())) {
                    elem.click();
                }
            }
        }

        System.out.println(propertyListspf50.get(0).getName());
        System.out.println(propertyListspf50.get(0).getPrice());
        List<WebElement> spf50 = driver.findElements(By.tagName("button"));
        if (!propertyListspf50.isEmpty()) {
            for (WebElement elem : spf50) {
                if (elem.getAttribute("onclick").contains(propertyListspf50.get(0).getName())) {
                    elem.click();
                }

            }
        }


    }
    public Cart clickCart()
    {
        clickcart.click();
        return new Cart();
    }


}
