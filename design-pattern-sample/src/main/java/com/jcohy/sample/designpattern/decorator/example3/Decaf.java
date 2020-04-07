package com.jcohy.sample.designpattern.decorator.example3;

/**
 * Created by jcohy on 2019/3/15.
 * ClassName  : com.jcohy.study.decorator.example3
 * Description  :
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 2.2;
    }
}
