package com.jcohy.sample.designpattern.singleton;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:52
 */
public class Singleton3 {

    // tag::code[]
    /**
     * 第三种: 双重校验锁
     * 加锁的懒汉模式看起来即解决了线程并发问题，又实现了延迟加载
     * 然而它存在着性能问题，依然不够完美。
     * synchronized 修饰的同步方法比一般方法要慢很多，如果多次调用 getInstance()
     * 累积的性能损耗就比较大了。因此就有了双重校验锁
     */
    	private static Singleton3 instance = null;
        private Singleton3(){}
        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {//2
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    /**
     * 由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
     * 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
     * 此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。
     * 若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
     * volatile的一个语义是禁止指令重排序优化，
     * 也就保证了instance变量被赋值的时候对象已经是初始化过的，
     * 从而避免了上面说到的问题。
     */
        public static Singleton3 getInstance2() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    // end::code[]
}
