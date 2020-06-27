package Base;

import java.util.Comparator;

public class Property {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public Property(String name, int price) {
        this.name = name;
        this.price = price;
    }

//    public int compare(Object o1, Object o2) {
//        Integer p1 = ((Property) o1).getPrice();
//        Integer p2 = ((Property) o2).getPrice();
//
//        if(p1 >p2)
//            return 1;
//        else if (p1< p2)
//            return -1;
//        else
//            return 0;
//
//    }
}
