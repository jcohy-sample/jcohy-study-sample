package com.jcohy.sample.designpattern.memento.example2;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:14
 */
// tag::code[]
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
// end::code[]