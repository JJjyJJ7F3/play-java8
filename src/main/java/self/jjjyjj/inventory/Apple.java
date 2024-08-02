package self.jjjyjj.inventory;

public class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isGreen() {
        return "green".equals(color);
    }

    public boolean isHeavy() {
        return weight > 150;
    }
}
