package self.jjjyjj.inventory;

import org.junit.jupiter.api.Test;
import self.jjjyjj.inventory.formatter.AppleFormatter;
import self.jjjyjj.inventory.predicate.ApplePredicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppleFilterTest {

    @Test
    void filter_returnsEmptyList_whenInventoryIsEmpty() {
        List<Apple> inventory = Collections.emptyList();
        Predicate<Apple> predicate = apple -> true;

        List<Apple> result = AppleFilter.filter(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void filter_returnsAll_whenPredicateAlwaysTrue() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        Predicate<Apple> predicate = apple -> true;

        List<Apple> result = AppleFilter.filter(inventory, predicate);

        assertEquals(inventory, result);
    }

    @Test
    void filter_returnsEmptyList_whenPredicateAlwaysFalse() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        Predicate<Apple> predicate = apple -> false;

        List<Apple> result = AppleFilter.filter(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void filter_returnsFilteredApples_whenPredicateMatchesSome() {
        Apple apple1 = new Apple("red", 150);
        Apple apple2 = new Apple("green", 120);
        Apple apple3 = new Apple("red", 180);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3);
        Predicate<Apple> predicate = apple -> "red".equals(apple.getColor());

        List<Apple> result = AppleFilter.filter(inventory, predicate);

        assertEquals(Arrays.asList(apple1, apple3), result);
    }

    @Test
    void filter_returnsEmptyList_whenPredicateMatchesNo() {
        Apple apple1 = new Apple("red", 150);
        Apple apple2 = new Apple("green", 120);
        List<Apple> inventory = Arrays.asList(apple1, apple2);
        Predicate<Apple> predicate = apple -> "yellow".equals(apple.getColor());

        List<Apple> result = AppleFilter.filter(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void filterApples_returnsEmptyList_whenInventoryIsEmpty() {
        List<Apple> inventory = Collections.emptyList();
        ApplePredicate predicate = apple -> true;

        List<Apple> result = AppleFilter.filterApples(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void filterApples_returnsAll_whenPredicateAlwaysTrue() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        ApplePredicate predicate = apple -> true;

        List<Apple> result = AppleFilter.filterApples(inventory, predicate);

        assertEquals(inventory, result);
    }

    @Test
    void filterApples_returnsEmptyList_whenPredicateAlwaysFalse() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        ApplePredicate predicate = apple -> false;

        List<Apple> result = AppleFilter.filterApples(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void filterApples_returnsFilteredApples_whenPredicateMatchesSome() {
        Apple apple1 = new Apple("red", 150);
        Apple apple2 = new Apple("green", 120);
        Apple apple3 = new Apple("red", 180);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3);
        ApplePredicate predicate = apple -> "red".equals(apple.getColor());

        List<Apple> result = AppleFilter.filterApples(inventory, predicate);

        assertEquals(Arrays.asList(apple1, apple3), result);
    }

    @Test
    void filterApples_returnsEmptyList_whenPredicateMatchesNo() {
        Apple apple1 = new Apple("red", 150);
        Apple apple2 = new Apple("green", 120);
        List<Apple> inventory = Arrays.asList(apple1, apple2);
        ApplePredicate predicate = apple -> "yellow".equals(apple.getColor());

        List<Apple> result = AppleFilter.filterApples(inventory, predicate);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void prettyPrintApple_returnsEmptyString_whenInventoryIsEmpty() {
        List<Apple> inventory = Collections.emptyList();
        AppleFormatter formatter = apple -> "Apple: " + apple.getColor() + ", " + apple.getWeight() + "g";

        String result = AppleFilter.prettyPrintApple(inventory, formatter);

        assertEquals("", result);
    }

    @Test
    void prettyPrintApple_returnsFormattedString_whenInventoryHasOneApple() {
        List<Apple> inventory = Collections.singletonList(new Apple("red", 150));
        AppleFormatter formatter = apple -> "Apple: " + apple.getColor() + ", " + apple.getWeight() + "g";

        String result = AppleFilter.prettyPrintApple(inventory, formatter);

        assertEquals("Apple: red, 150g\n", result);
    }

    @Test
    void prettyPrintApple_returnsFormattedString_whenInventoryHasMultipleApples() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        AppleFormatter formatter = apple -> "Apple: " + apple.getColor() + ", " + apple.getWeight() + "g";

        String result = AppleFilter.prettyPrintApple(inventory, formatter);

        assertEquals("Apple: red, 150g\nApple: green, 120g\n", result);
    }

    @Test
    void prettyPrintApple_handlesNullFormatterGracefully() {
        List<Apple> inventory = Arrays.asList(new Apple("red", 150), new Apple("green", 120));
        AppleFormatter formatter = apple -> null;

        String result = AppleFilter.prettyPrintApple(inventory, formatter);

        assertEquals("null\nnull\n", result);
    }
}