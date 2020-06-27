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
import java.util.List;



public class buyMoisturizersPage extends TestBase {

    @FindBy(xpath = "/html/body/title")
    WebElement title;

    @FindBy(xpath = "/html/body/nav/ul/button")
    WebElement clickcart;


    public buyMoisturizersPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void getMoisturizers()
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

        int tcount = 0;
        Property property = null;
        List<Property> propertyListAloe = new ArrayList<Property>();
        List<Property> propertyListAlmond = new ArrayList<Property>();

        for(String name: nameList)
        {
            if (name.contains("Aloe"))
            {
                property = new Property(name,priceList.get(tcount));
                propertyListAloe.add(property);
            }

            else if (name.contains("Almond"))
            {
                property = new Property(name,priceList.get(tcount));
                propertyListAlmond.add(property);
            }
            tcount++;
        }


        Collections.sort(propertyListAloe,new PropertyCompare());
        Collections.sort(propertyListAlmond,new PropertyCompare());


        System.out.println(propertyListAlmond.get(0).getName());
        System.out.println(propertyListAlmond.get(0).getPrice());
        List<WebElement> almond = driver.findElements(By.tagName("button"));
       if (!propertyListAlmond.isEmpty()) {
           for (WebElement elem : almond) {
               if (elem.getAttribute("onclick").contains(propertyListAlmond.get(0).getName())) {
                   elem.click();
               }
           }
       }


        System.out.println(propertyListAloe.get(0).getName());
        System.out.println(propertyListAloe.get(0).getPrice());
        List<WebElement> aloe = driver.findElements(By.tagName("button"));
        if (!propertyListAloe.isEmpty())
        {
        for(WebElement elem : aloe)
        {
            if(elem.getAttribute("onclick").contains(propertyListAloe.get(0).getName()))
            {
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
