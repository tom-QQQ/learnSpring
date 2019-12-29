package demo.model.decorate.compoent.decorator.condiment;


import demo.model.decorate.compoent.AbstractBeverage;
import demo.model.decorate.compoent.decorator.AbstractDecorator;

/**
 * @author Ning
 * @date Create in 2019/3/28
 */
public class Soy extends AbstractDecorator {

    private AbstractBeverage beverage;

    public Soy(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 豆浆";
    }

    @Override
    public double cost() {
        return exactResult(0.15, beverage.cost());
    }
}
