package com.atguigu.projectdemo1.customercrm.view

import com.atguigu.projectdemo1.customercrm.bean.Customer
import com.atguigu.projectdemo1.customercrm.service.CustomerService
import util.control.Breaks._
import scala.io.StdIn

class CustomerView {
  //空置死否退出while
  var loop = true
  //接收用户输入
  var key =' '

  val CustomerService = new CustomerService()
  def mainMenu(): Unit ={
    do{
      println("-----------------客户信息管理软件-----------------")
      println("                 1 添 加 客 户")
      println("                 2 修 改 客 户")
      println("                 3 删 除 客 户")
      println("                 4 客 户 列 表")
      println("                 5 退 出")
      println("                 请选择(1-5)：_")
      key = StdIn.readChar()
      key match{
        case '1' => this.add()
        case '2' => println(" 修 改 客 户")
        case '3' => this.del()
        case '4' => this.list()
        case '5' => this.loop = false
      }

    } while(loop)

    println("您退出了系统")
  }

  def list():Unit = {
    println()
    println("---------------------------客户列表---------------------------")
    println("编号\t\t 姓名\t\t 性别\t\t 年龄\t\t 电话\t\t 邮箱")
    //获取到 CustomerSerivce 的 customers ArrayBuffer
    val customers = CustomerService.list()
    for (customer <- customers){
      //重写Customer的toString方法，返回信息
      println(customer)
    }
    println("-------------------------客户列表完成-------------------------")
  }

  def add():Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()

    val customer = new Customer(name,gender,age,tel,email)
    CustomerService.add(customer)
    println("---------------------添加完成---------------------")
  }

  def del():Unit = {
    println("---------------------删除客户---------------------")
    println("请选择待删除客户编号(-1 退出)：")
    val id = StdIn.readInt()
    if (id == -1) {
      println("---------------------删除没有完成---------------------")
      return
    }
    println("确认是否删除(Y/N)：")
    var choice = ' '
    breakable {
      do {
        choice = StdIn.readChar().toLower
        if (choice == 'y' || choice == 'n') {
          break()
        }
        println("输入有误，请重新删除")
      } while (true)
    }

    if (choice == 'y') {
      if (CustomerService.del(id)) {
        println("---------------------删除完成---------------------")
        return
      }
    }
    println("---------------------删除没有完成---------------------")

  }

}
