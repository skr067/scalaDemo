package com.atguigu.chapter


object ScalaDemo2 {
  def main(args: Array[String]): Unit = {
    /**
      * 一个空的块表达式{}的值是什么？类型是什么
      */
   val t={}
    println("t="+t+""+t.isInstanceOf[Unit])

    /**
      * 针对下列java循环编写一个scala版本
      * for(int i=10;i>=0;i--)sout(i)
      */
    for(i <- 0 to 10 reverse){
      println(i)
    }

    /**
      * 编写一个过程countdown(n:Int)，打印从n到0的数字
      */
    val d=3
    (0 to d).reverse.foreach(println)

    /**
      * 编写一个for循环，计算字符串中所有字母的Unicode代码的乘积。举例来说Hello中所有字符串的乘积为9415087488L
      */
    var res: Long = 1
    for(i <- "Hello"){
      res*=i.toLong
    }
    println("res=" + res)

    var r: Long = 1
    "Hello".foreach(r*= _.toLong)
    println(r)
  }
}
