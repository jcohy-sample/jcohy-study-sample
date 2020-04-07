package com.jcohy.sample.designpattern.proxy.example2;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:36
 */
// tag::code[]
public class Client {
    public static void main(String[] args) {
        Subject su = new Proxy();
        su.method();
    }
}
// end::code[]