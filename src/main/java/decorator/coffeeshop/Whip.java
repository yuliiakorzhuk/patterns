package decorator.coffeeshop;

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return this.beverage.cost() + .10;
    }

}
