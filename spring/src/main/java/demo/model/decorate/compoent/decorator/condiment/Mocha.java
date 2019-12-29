package demo.model.decorate.compoent.decorator.condiment;


import demo.model.decorate.compoent.AbstractBeverage;
import demo.model.decorate.compoent.decorator.AbstractDecorator;

/**
 * 配料, 装饰对象
 * @author Ning
 * @date Create in 2019/3/28
 */
public class Mocha extends AbstractDecorator {

    AbstractBeverage beverage;

    public Mocha(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 摩卡";
    }

    @Override
    public double cost() {
        return exactResult(0.2, beverage.cost());
    }
}
