package com.jcohy.sample.designpattern.mediator;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 * 表示要跟顾问咨询的成员的接口(具体成员ColleagueButton,ColleagueTextFiled....)
 * @author jcohy
 *
 */
public interface Colleague {
	void setMediator(Mediator mediator);
	void setColleagueEnabled(boolean enabled);
}
// end::code[]