package self.jjjyjj.inventory.formatter;

import self.jjjyjj.inventory.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getColor() + " color and " + apple.getWeight() + "g weight";
    }
}
