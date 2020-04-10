package com.jcohy.sample.algorithm.SimpleQuestion;

/**
 * Created by jcohy on 2019/3/25.
 * ClassName  : com.study.demo
 * Description  :
 */

public class test3 {
    // tag::code[]
    public static void main(String[] args) {
        reversePrintStar(4);
    }

    static void reversePrintStar(int line) {

        //设置行数
        for (int row = 0; row <= line; row++) {
            //设置缩进
            for (int i = 0; i <= row - 1; i++) {
                System.out.print(" ");
            }
            for (int col = line; col > row; col--) {
                System.out.print("*" + " ");
            }

            System.out.println();

        }
    }
    // end::code[]
}
