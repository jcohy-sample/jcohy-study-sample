package com.jcohy.sample.algorithm.arrays;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

/**
 * Copyright: Copyright (c) 2020 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/14:17:24
 * @since 1.0.0
 */
public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop){
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("p(pool):从队列中取出数据");
			System.out.println("h(head):显示头数据");
			key = scanner.next().charAt(0);
			switch (key){
				case 's':
					arrayQueue.show();
					break;
				case 'e':
					scanner.close();
					loop = false;
					System.out.println("程序退出");
					break;
				case 'a':
					System.out.println("请输入添加的数据");
					int data = scanner.nextInt();
					arrayQueue.add(data);
					break;
				case 'p':
					try {
						int poll = arrayQueue.poll();
						System.out.printf("取出的数据是：%d\n",poll);
					}catch (RuntimeException e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int peek = arrayQueue.peek();
						System.out.printf("队列头的数据是：%d\n",peek);
					}catch (RuntimeException e){
						System.out.println(e.getMessage());
					}
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + key);
			}
		}
	}
}

class ArrayQueue {
	private int front;

	private int rear;

	private int maxSize;

	private int[] arr;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		//队列头部
		front = -1;
		//队列尾部
		rear = -1;
	}

	public boolean isEmpty(){
		return front == rear;
	}

	public boolean isFull(){
		return rear == maxSize-1;
	}
	public void add(int n){
		if(isFull()){
			System.out.println("队列满，不能加入队列");
			return;
		}
		arr[++rear] = n;
	}

	public int poll(){
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}

		return arr[++front];
	}

	public int peek(){
		if(isEmpty()){
			throw new RuntimeException("队列为空");
		}

		return arr[front+1];
	}

	public void show(){

		if(isEmpty()){
			System.out.println("队列中没有数据");
			return;
		}
		for(int i=0;i<arr.length;i++){
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}

}