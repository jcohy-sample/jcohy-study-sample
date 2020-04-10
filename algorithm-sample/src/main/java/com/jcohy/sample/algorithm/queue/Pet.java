package com.jcohy.sample.algorithm.queue;
// tag::code[]
/**
 * 猫狗队列
 *
 * @author jcohy
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Pet [type=" + type + "]";
    }
}
// end::code[]