package demo.model.decorate.compoent.decorator.cup;


import demo.model.decorate.compoent.AbstractBeverage;

/**
 * @author Ning
 * @date Create in 2019/3/28
 */
public class LargeCup extends AbstractBeverage {

    private AbstractBeverage beverage;

    public LargeCup(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 大杯";
    }

    @Override
    public double cost() {
        return exactResult(0.2, beverage.cost());
    }
}
