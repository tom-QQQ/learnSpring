package demo.model.decorate.compoent.decorator.cup;


import demo.model.decorate.compoent.AbstractBeverage;
import demo.model.decorate.compoent.decorator.AbstractDecorator;

/**
 * @author Ning
 * @date Create in 2019/3/28
 */
public class LittleCup extends AbstractDecorator {

    private AbstractBeverage beverage;

    public LittleCup(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "小杯";
    }

    @Override
    public double cost() {
        return exactResult(0.10, beverage.cost());
    }
}
