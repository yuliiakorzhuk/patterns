package decorator.coffeeshop;

public class SteamedMilk extends CondimentDecorator {
    private Beverage beverage;

    public String getDescription() {
        return this.beverage.getDescription() + ", Steamed Milk";
    }

    public SteamedMilk(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return this.beverage.cost() + .10;
    }

}
