package decorator.coffeeshop;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return this.beverage.cost() + .20;
    }

}
