package self.jjjyjj.inventory;

import org.junit.jupiter.api.Test;

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
}