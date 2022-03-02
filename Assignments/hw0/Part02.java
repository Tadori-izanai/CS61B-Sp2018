package Assignments.hw0;

import javax.crypto.interfaces.PBEKey;
import javax.xml.transform.sax.SAXTransformerFactory;

public class Part02 {
    public static void main(String[] args) {
//        method01();
//        method02();
//        method03();
//        method04();
    }

    // 数组
    public static void method01() {
        // 定义一个 int 数组
        int[] numbers = new int[3];             // 声明并分配内存
        numbers[0] = 4;
        numbers[1] = 7;
        numbers[2] = 10;
        System.out.println(numbers[1]);

        // 另一种等价的声明方法 (but less general)
        int[] numbers2 = new int[]{4, 7, 10};   // 声明并分配内存并赋值
        System.out.println(numbers2[1]);
        // 也可以拆解为 3 步
        int[] numbers3;
        numbers3 = new int[3];
        numbers3[0] = 4;
        numbers3[1] = 7;
//        numbers3[2] = 10;
        System.out.println(numbers3[1]);

        // 获取所使用的数组的长度(通过 .length)
        System.out.println(numbers3.length);    // 值为 3
    }


    // for 循环
    public static void method02() {
        int[] a = {4, 3, 2, 1};
        System.out.println(sum(a));
        System.out.println("----");

        // 可以使用 , 来分割
        for (int i = 0, j = 10; i < j; i++)
            System.out.println(i + j);
    }
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }


    // break and continue
    public static void method03() {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains("horse"))         // 使用了 contains()
                continue;                       // 跳过了包含 horse 字串的元素
            for (int j = 0; j < 3; j++)
                System.out.println(a[i]);
        }
        System.out.println("-----------");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(a[i]);
                if (a[i].contains("horse"))
                    break;                      // 只跳出了一层循环
            }
        }
    }


    // enhanced for loop
    public static void method04() {
        // 有时, 写一个循环并不关心数组的 index, 则可以使用一个涉及 colon 的特殊语法
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        for (String s : a) {
            for (int j = 0; j < 3; j++) {
                System.out.println(s);
                if (s.contains("horse"))
                    break;
            }
        } // s 依次取值 a[0], a[1], ..., a[a.length - 1].
    }
}
