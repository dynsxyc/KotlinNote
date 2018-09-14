package com.zhongjiang.kotlin

fun main(args: Array<String>) {
    /**
    定义局部变量
    一次赋值（只读,相当于java中的静态常量）的局部变量：
     */
    val a: Int = 1 //立即赋值
    val b = 2 //自动推断出 'Int'
    val c: Int //如果没有初始值类型不能省略
    c = 5
    /**可变变量*/
    var x = 5 //自动推断类型
    x += 2
    System.out.println(x)

    /**使用字符串模板*/
    val s1 = "a is $a  还可以这样 ${a + b}  或者这样${sum(a, b)}"

    /**使用if表达式*/
    if (a > b) a else b

    /** 使用可控值及 null 检测
     * 当某个变量的值可以为null的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
     * */
    val string: String = ""
    println("空检测 ${printInt(string)}")
    val xStr = printInt("9")
    val y = printInt("3")
    if (xStr != null && y != null) {
        println(xStr * y)
    } else {
        println("either '$x' or '$y' is not a number")
    }

    /**使用类型检测及自动类型转换
     * is 运算符检测一个表达式是否是某类型的一个实例。如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中
     * 可以直接当作该类型使用，无需显示转换：
     * */
    var obj: Any
    obj = "777"
    if (obj is String) {
        println("is 运算符 使用 ${obj.length} ")
    }
    if (obj !is Int) {
        println("obj  不是个类型 $obj")
    }

    /**使用for 循环*/
    val items = listOf("apple", "banana", "kiwi")
    items.forEach {
        println("for循环 forEach " + it)
    }
    for (item in items) {
        println("for循环  in " + item)
    }
    for (index in items.indices) {
        println("for 循环 index indices ${items[index]}")
    }

    /**使用while循环*/
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
    /**使用when表达式*/
    println("使用when表达式 = " + describe(1))
    println("使用when表达式 = " + describe("Hello"))
    println("使用when表达式 = " + describe(1000L))

    /**使用区间 range */
    testRange()
    /**使用集合*/
    testList()

    println();
    println();
    println();

    println("Hello World")
    printSum(2, 5)


}

/**
定义函数
带有两个Int参数 、 返回Int 的函数
 */
fun sum(a: Int, b: Int): Int {
    return a + b;
}

/**
将表达式作为函数体、返回值类型自动推断的函数：*/
fun sum1(a: Int, b: Int) = a + b

/**
函数返回无意义的值：
Unit 可以省略
 */
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and  $b is ${a + b}")
}

/**如果string 的内容不是数字返回null
 * 使用返回可空值的函数
 * */
fun printInt(string: String): Int? {
    return string.toIntOrNull()
}

/** 使用when表达式*/
fun describe(obj: Any): String {
    return when (obj) {
        1 -> "one"
        is String -> "is a String"
        else -> "Unknown"
    }
}

/**使用区间  range*/
fun testRange() {
    println("***********************************  Range start **********************************")
    val rangeX = 10
    val rangeY = 9
    if (rangeX in 1..rangeY + 1) {
        println("fits in range")
    }
    val list = listOf<String>("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range ")
    }
    //list.indices 返回的是 list 对应的 index 区间
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    //区间迭代
    for (x in 1..5) {
        println("简单区间迭代  " + x)
    }
    for (x in 1..10 step 2) {//x 在1到10循环  循环步长(step) 2  输出1,3,5,7,9
        println("数列迭代 $x in  1..4 step 2   $x")
    }
    for (x in 9 downTo 0 step 2) {//x 在9到0 降级循环  循环步长(step) 2  输出9,7,5,3,1
        println("数列迭代  $x in 9 downTo 0 step 2   $x")
    }

    println("***********************************  Range end **********************************")
}

fun testList() {
    println("***********************************  使用集合 start **********************************")
    val items = listOf("apple", "banana", "kiwi","abc","all")
    for (item in items) {
        println(item)
    }
    //使用 in 运算符判断集合内是否包含实例
    if ("orange" !in items) {
        println("orange not in items")
    }
    if ("apple" in items) {
        println("apple in items")
    }
    when {
        "orange" in items -> Unit
        "apple" in items -> println("哈哈")

    }
    //使用 lambda 表达式来过滤（filter）和映射（map）集合：
    items.filter {
        it.startsWith("a")
    }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println("***********************************  使用集合 end **********************************")
}



