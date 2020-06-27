package Base;

import java.util.Comparator;

public class PropertyCompare implements Comparator<Property> {
    public int compare(Property o1, Property o2) {
        return o1.getPrice() < o2.getPrice() ? -1: o1.getPrice() == o2.getPrice() ? 0:1;
    }
}
