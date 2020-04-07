package com.jcohy.sample.designpattern.decorator.example3;

/**
 * Created by jcohy on 2019/3/15.
 * ClassName  : com.jcohy.study.decorator.example3
 * Description  :
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
    public double cost() {
        return .20 + beverage.cost();
    }
}
