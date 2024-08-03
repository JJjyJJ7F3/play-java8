package self.jjjyjj.inventory.predicate;

import self.jjjyjj.inventory.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
