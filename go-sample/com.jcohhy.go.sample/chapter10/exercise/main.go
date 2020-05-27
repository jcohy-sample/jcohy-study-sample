package main

import (
	"fmt"
)

type Person struct {
	Name string
	Age  int
}

func main() {

	var p1 Person
	p1.Age = 10
	p1.Name = "小明"
	var p2 *Person = &p1 //这里是关键-->画出示意图

	fmt.Println((*p2).Age) // 0
	fmt.Println(p2.Age)    // 0
	p2.Name = "tom~"
	fmt.Printf("p2.Name=%v p1.Name=%v \n", p2.Name, p1.Name)    // p2.Name=tom~ p1.Name=tom~
	fmt.Printf("p2.Name=%v p1.Name=%v \n", (*p2).Name, p1.Name) // p2.Name=tom~ p1.Name=tom~

	fmt.Printf("p1的地址%p\n", &p1)            // p2的地址0xc0420023e0
	fmt.Printf("p2的地址%p p2的值%p\n", &p2, p2) // p2的地址0xc042004028 p2的值0xc0420023e0

}
