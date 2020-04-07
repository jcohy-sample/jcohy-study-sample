package com.jcohy.sample.designpattern.memento.example2;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 14:13
 */
// tag::code[]
public class Original {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}
// end::code[]