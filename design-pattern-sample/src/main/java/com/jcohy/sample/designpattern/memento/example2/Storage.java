package com.jcohy.sample.designpattern.memento.example2;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:14
 */
// tag::code[]
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
// end::code[]