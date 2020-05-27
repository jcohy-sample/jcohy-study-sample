package main

import (
	"fmt"
)

func main() {
	//演示关系运算符的使用

	var A int = 10
	var B int = 20
	fmt.Println(B == A) //false
	fmt.Println(B != A) //true
	fmt.Println(B > A)  //true
	fmt.Println(B >= A) //true
	fmt.Println(B < A)  //flase
	fmt.Println(B <= A) //flase
	flag := B > A
	fmt.Println("flag=", flag)
}
