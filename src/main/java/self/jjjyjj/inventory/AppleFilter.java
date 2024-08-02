package self.jjjyjj.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    /**
     * Filters a list of apples based on a given predicate.
     *
     * @param inventory the list of apples to be filtered
     * @param p the predicate used to filter the apples
     * @return a list of apples that match the predicate
     */
    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}