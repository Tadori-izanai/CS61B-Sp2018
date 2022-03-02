package Assignments.hw0;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ThreadPoolExecutor;

public class Part01 {
    public static void main(String args[]) {
//        method01();
//        method02();
//        method03();
//        method04();
        method05();
    }


    // if 语句
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

    // else 语句
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

    // while 语句
    public static void method03() {
        int bottles = 99;
        // while 语句
        while (bottles > 0) {
            System.out.println(bottles + " bottles of beer on the wall");
            bottles--;
        }
    }

    // String 和 double
    public static void method04() {
        // 阿基里斯和其龟
        String a = "Achilles";
        String t = "Tortoise";
        double aPos = 0;
        double tPos = 100;
        double aSpeed = 20;
        double tSpeed = 10;
        double totalTime = 0;
        while (aPos < tPos) {
            // 显式位置
            System.out.println("At time: " + totalTime);
            System.out.println("\t" + a + " is at position " + aPos);
            System.out.println("\t" + t + " is at position " + tPos);
            // 计算下一时刻位置
            double timeToReach = (tPos - aPos) / aSpeed;    // 追到归上一时刻的位置
            totalTime += timeToReach;
            aPos += timeToReach * aSpeed;
            tPos += timeToReach * tSpeed;
        }
        /*
        At time: 9.999999999999995
        Achilles is at position 199.99999999999991
        Tortoise is at position 199.99999999999994
         */
        System.out.print('*');      // print 与 println 基本相同
        System.out.println('*');    // 不同的是 println 在末尾自动添加换行符
    }

    // 使用函数
    public static void method05() {
        // 调用函数
        System.out.println(max(10, 15));
    }
     // 函数在 Java 中被称为 methods
    public static int max(int x, int y)         // 这一行称为 method 的 signature
    {
        if (x > y)
            return x;
        else
            return y;
    }

}

