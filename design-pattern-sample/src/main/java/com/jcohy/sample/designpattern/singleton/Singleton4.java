package com.jcohy.sample.designpattern.singleton;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:54
 */
public class Singleton4 {
    // tag::code[]
    /**
     * 第四种: 内部类
     */
    	private static class SingletonHolder{
            public static Singleton4 instance = new Singleton4();
        }

        private Singleton4(){}

        public static Singleton4 newInstance(){
            return SingletonHolder.instance;
        }
    // end::code[]
}
