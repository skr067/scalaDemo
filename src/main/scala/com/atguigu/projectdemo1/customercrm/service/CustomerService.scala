package com.atguigu.projectdemo1.customercrm.service

import com.atguigu.projectdemo1.customercrm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

class   CustomerService {
  //ArrayBuffer是变长数组，类似ArrayList
  var customers = ArrayBuffer(new Customer(1,"tom",'男',10,"110","tom@sohu.com"))
  var customerNum = 1

  def list():ArrayBuffer[Customer] = {
    this.customers
  }

  def add(customer:Customer): Boolean = {
    //设置id
    customerNum += 1
    customer.id = customerNum
    customers.append(customer)
    true
  }
  def del(id:Int): Boolean = {
    val index = findIndexById(id)
    if (index != -1){
      customers.remove(index)
      true
    } else {
      false
    }
  }

  def findIndexById(id: Int): Int = {
    var index = -1
    //遍历customers
    breakable {
      for (i <- 0 until customers.length) {
        if (customers(i).id == id) {
          index = i
          break()
        }
      }
    }
      index
    }
}
