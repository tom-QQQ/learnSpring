package demo.model.decorate.compoent.decorator.condiment;


import demo.model.decorate.compoent.AbstractBeverage;
import demo.model.decorate.compoent.decorator.AbstractDecorator;

/**
 * @author Ning
 * @date Create in 2019/3/28
 */
public class Whip extends AbstractDecorator {

    private AbstractBeverage beverage;

    public Whip(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 奶泡";
    }

    @Override
    public double cost() {
        return exactResult(0.1, beverage.cost());
    }
}
