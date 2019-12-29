package demo.model.strategy.impl;


import demo.model.strategy.AbstractDuck;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public class MallardDuck extends AbstractDuck {

    @Override
    public void display() {
        System.out.println("我是一只绿头鸭");
    }
}
