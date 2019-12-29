package demo.model.decorate.compoent.decorator;

import demo.model.decorate.compoent.AbstractBeverage;

/**
 * 配料抽象类, 即装饰者类
 * @author Ning
 * @date Create in 2019/3/28
 */
public abstract class AbstractDecorator extends AbstractBeverage {

    /**
     * 获取名称
     * @return 名称
     */
    @Override
    public abstract String getDescription();
}
