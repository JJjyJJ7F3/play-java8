package self.jjjyjj.inventory.predicate;

import self.jjjyjj.inventory.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
