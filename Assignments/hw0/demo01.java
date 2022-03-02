package Assignments.hw0;

public class demo01 {
    public static void main(String args[]) {
//        method01();
        method02();
    }


    public static void method01() {
        int x = 5;  // a static type

        // 所有 statement 以分号结尾

        System.out.println(x);  // 打印方式
        if (x < 10)             // 条件语句
//            x = x + 10;
            x += 10;
        System.out.println(x);


        x = 15;
        if (x < 10) {
            System.out.println("I shall increment x by 10");
            x = 10 + x;
        }                       // 多语句使用花括号
    }


    public static void method02() {
        // else 语句
        int x = 9;
        if (x - 3 > 8) {
            System.out.println("(x - 3) is greater than 8");
            System.out.println("(x - 3) is greater than 8");
        } else {
            System.out.println("(x - 3) is not greater than 8");
            System.out.println("(x - 3) is not greater than 8");
        }

        // else if 语句
        int dogSize = 20;
        if (dogSize >= 50)
            System.out.println("woof");
        else if (dogSize >= 10)
            System.out.println("bark");
        else
            System.out.println("yip");
    }
}

