package main

import (
	"fmt"
)

func main() {

	var A int = 60

	var B int = 13

	//位运算的演示
	fmt.Println(A & B) // 12
	fmt.Println(A | B) // 61
	fmt.Println(A ^ B) // 49

	a := A >> 2                   //0
	c := A << 2                   //4
	fmt.Println("a=", a, "c=", c) // a= 15 c= 240

}
