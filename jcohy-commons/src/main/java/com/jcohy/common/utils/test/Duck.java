package com.jcohy.common.utils.test;

/**
 * Created by jiac on 2019/3/12.
 * ClassName  : com.jcohy.study.test
 * Description  :
 */
public abstract class Duck {
    public FlywayBehavior flywayBehavior;
    public QucakBahavior qucakBahavior;
    Duck(){}
    public void swim(){

    }
    public abstract void display();

    public void preformFly(){
        flywayBehavior.fly();
    }

    public void preformQucak(){
        qucakBahavior.quack();
    }
}
