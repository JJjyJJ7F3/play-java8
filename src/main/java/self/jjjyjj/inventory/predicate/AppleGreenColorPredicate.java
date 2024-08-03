package self.jjjyjj.inventory.predicate;

import self.jjjyjj.inventory.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
