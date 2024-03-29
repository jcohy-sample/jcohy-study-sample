package com.jcohy.sample.designpattern.observer.demo2;

/**
 * Created by jcohy on 2019/3/15. ClassName : com.jcohy.study.observer.demo2 Description :
 */
public interface Subject {

	void register(Observer observer);

	void remove(Observer observer);

	public void notifyObservers();

}
