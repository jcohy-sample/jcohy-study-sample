package com.jcohy.sample.algorithm.arrays;

import java.io.IOException;

// tag::code[]
public class SparseMatrix {
    /**
     * 稀疏矩阵:一个矩阵中大部分元素都为0，即可称为 "稀疏矩阵" 。如果直接使用传统的二维数组来存储，会造成
     * 内存空间大量浪费，改进的方法为三项式(3-tuple)。例如:
	 * 000000000
	 * 050040000
	 * 060000000
	 * 000800000
	 * 010000700
	 * 000000000
	 * 200000000
	 * 000003000
	 * 系数矩阵压缩后的内容为:
	 * 8 9 8
	 * 1 1 5
	 * 1 4 4
	 * 2 1 6
	 * 3 3 8
	 * 4 1 1
	 * 4 6 7
	 * 6 0 2
	 * 7 5 3
	 *
	 *
     *	A(0,1)=表示此矩阵的行数					   8
     *	A(0,2)=表示此矩阵的列数					   9
     *	A(0,3)=表示此矩阵的非零项目的总数。			   8
     *  利于此三项式数据结构来压缩稀疏矩阵的方法。可以减少内存的不必要的浪费。
     */
    public static void main(String[] args) throws IOException {
        //定义行数
        final int ROWS = 8;
        //定义列数
        final int COLS = 9;
        //定义稀疏矩阵中不为0的数
        final int NOTZERO = 8;
        int i, j, rw, cl, nz;
        int temp = 1;
        //声明稀疏矩阵
        int[][] Sparse = new int[ROWS][COLS];
        //声明压缩矩阵
        int[][] Compress = new int[NOTZERO + 1][3];
        //将稀疏矩阵的元素全设为0
        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLS; j++) {
                Sparse[i][j] = 0;
            }
        }

        nz = NOTZERO;
        for (i = 1; i < nz + 1; i++) {
            rw = (int) (Math.random() * 100);
            rw = rw % ROWS;
            cl = (int) (Math.random() * 100);
            cl = cl % COLS;
            if (Sparse[rw][cl] != 0) {
                nz++;//避免同一元素设定两次数值而造成压缩矩阵中有0
            }
            //随机产生稀疏矩阵中非零的元素值
            Sparse[rw][cl] = i;
        }
        System.out.println("打印矩阵中的元素");
        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLS; j++) {
                System.out.print(Sparse[i][j] + "");
            }
            System.out.println();
        }
        //开始压缩稀疏矩阵
        Compress[0][0] = ROWS;
        Compress[0][1] = COLS;
        Compress[0][2] = NOTZERO;
        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLS; j++) {
                if (Sparse[i][j] != 0) {
                    Compress[temp][0] = i;
                    Compress[temp][1] = j;
                    Compress[temp][2] = Sparse[i][j];
                    temp++;
                }
            }
        }
        System.out.println("稀疏矩阵压缩后的内容为:");
        for (i = 0; i < NOTZERO + 1; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(Compress[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// end::code[]