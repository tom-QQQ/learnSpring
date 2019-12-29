package demo.model.strategy.behavior.quack.impl;


import demo.model.strategy.behavior.quack.QuackBehavior;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("发出呱呱叫");
    }
}
