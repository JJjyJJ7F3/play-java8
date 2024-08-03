package self.jjjyjj.inventory;

import self.jjjyjj.inventory.formatter.AppleFormatter;
import self.jjjyjj.inventory.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    /**
     * Filters a list of apples based on a given predicate.
     *
     * @param inventory the list of apples to be filtered
     * @param p         the predicate used to filter the apples
     * @return a list of apples that match the predicate
     */
    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream()
                .filter(p)
                .toList();
    }

    /**
     * Filters a list of apples based on a given predicate.
     *
     * @param inventory the list of apples to be filtered
     * @param p         the predicate used to filter the apples
     * @return a list of apples that match the predicate
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Pretty prints a list of apples based on a given formatter.
     *
     * @param inventory the list of apples to be pretty printed
     * @param formatter the formatter used to pretty print the apples
     * @return a string representation of the pretty printed apples
     */
    public static String prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        StringBuilder sb = new StringBuilder();
        for (Apple apple : inventory) {
            sb.append(formatter.accept(apple)).append("\n");
        }
        return sb.toString();
    }
}