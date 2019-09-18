package decorator.coffeeshop;

public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        System.out.println("here");
        if(this.beverage.size == Size.VENTI){
            return this.beverage.cost() + .15;
        }
        if(this.beverage.size == Size.GRANDE){
            return this.beverage.cost() + .20;
        }
        else return this.beverage.cost() + .10;

//        switch (size){
//            case TALL: beverage.cost() =  this.beverage.cost() + .10;
//            case VENTI: return this.beverage.cost() + .15;
//            case GRANDE: return this.beverage.cost() + .20;
//        }
    }

}
