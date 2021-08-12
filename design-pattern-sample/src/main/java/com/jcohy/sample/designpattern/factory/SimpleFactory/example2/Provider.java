package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="https://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 13:36
 */
// tag::code[]
public interface Provider {
    public Sender produce();
}
// end::code[]