package com.atguigu.chapter

object ScalaDemo3 {
  def main(args: Array[String]): Unit = {
    println(product("hello"))
  }

  def product(s:String): Long = {
    var r: Long =1L
    s.foreach(r*= _.toLong)
    r

  }

}
