package com.atguigu.chapter

/**
  * 一个数字如果为正数，则它的signum为1；如果是负数，则signum为-1；
  * 如果为0，则signum为0，编写一个函数来计算这个值
  */
object ScalaDemo1 {
  def main(args: Array[String]): Unit = {
      println(signum(20))
  }

  def signum(num : Int): Int = {
    if(num > 0){
      return 1
    } else if(num < 0){
      return -1
    } else{
      return 0
    }
  }


}
