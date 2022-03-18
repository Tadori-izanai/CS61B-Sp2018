# 3 Testing and Selection Sort

## 3.1 Testing

### A New Way

1. 编写测试 (可以在 method 实现之前就写好测试程序)。例如要测试一个排序 method，可以

    ```java
    public class TestSort {
        public static void testSort() {
            String[] input = {"i", "have", "an", "egg"};
            String[] expected = {"an", "egg", "have", "i"};
            Sort.sort(input);	// 排序
            // 整体判断
            if (!java.util.Arrays.equals(input, expected))  // 注意不可以是 (input != expected)
                System.out.println("Error! There seems to be a problem with Sort.sort().");
            // 逐个判断
            for (int i = 0; i < input.length; i++) {
                if (!input[i].equals(expected[i])) {
                    System.out.println("Mismatch in position " + i + ". expected: " + expected[i] +
                                       ", but got: " + inpub[i] + ",");
                    break;
                }
            }
        }
        public static void main(String[] args) {
            testSort();
        }
    }
    ```

    - 注意 `input[i] == expected[i]` 判断的是两个 String 地址是否相同，而不是内容所以需要

        ```java
        input[i].equals(expected[i])
        ```

    - 判断数组中的元素是否相同时，需要使用内置 method

        ```java
        java.util.Arrays.equals(input, expected)
        ```

### JUnit Testing

2. `org.junit` library 提供许多可以用于测试功能的 method

    - 测试数组中的元素是否都相同 `assertArrayEquals`
    
        ```java
        // 使用 org.junit
        org.junit.Assert.assertArrayEquals(expected, input);		// 比较并输出错误信息 (如果有)
        ```
    
    - 测试一个值 `assertEquals`
    
        ```java
        org.junit.Assert.assertEquals(expected, actual);
        ```
    

---

<br />

## 3.2 Selection Sort

### findSmallest

1. 先来实现一个 method, 用于找出一个 String 数组中的最小值。

    ```java
    public static String findSmallest(String[] str) {
        String smallest = str[0];
        for (String s : str) {
            if (s.compareTo(smallest) < 0)
                smallest = s;
        }
        return smallest;
    }
    ```

    - 注意不能用不等号来判断两个 String 的大小，需要使用 `str1.compareTo(str2)`. 若 `str1 < str2` 则返回一个负数，相等则返回整数，否组返回 0.

    - 可以写一个测试 method

        ```java
        public static void testFindSmallest() {
            String[] input = {"i", "have", "an", "egg"};
            String expected = "an";
            String actual = Sort.findSmallest(input);
            org.junit.Assert.assertEquals(expected, actual);
        }
        ```

### Swap

2. 来实现在一个 String 数组中，交换位置为 a, b 的元素的值

    ```java
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    ```

    - 可以编写一个测试 method

        ```java
        public static void testSwap() {
            String[] input = {"i", "have", "an", "egg"};
            int a = 0;
            int b = 2;
            String[] expected = {"an", "have", "i", "egg"};
            Sort.swap(input, a, b);
            org.junit.Assert.assertArrayEquals(expected, input);
        }
        ```

### Revising findSmallest

3. 考虑修改 `findSmallest`，让其返回的是最小元素的下标

    ```java
    private static int findSmallestIndex(String[] str) {
        int smallestIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].compareTo(str[smallestIndex]) < 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }
    ```


### Recurvsive Helper Method

### Debuging and Completing Sort

4. 先考虑改进 `findSmallestIndex()`

    ```java
    private static int findSmallestIndex(String[] str, int start) {
        int smallestIndex = start;
        for (int i = start; i < str.length; i++) {
            if (str[i].compareTo(str[smallestIndex]) < 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }
    ```

    然后实现 `sort()`, 同时考虑利用两个参数的辅助函数

    ```java
    public static void sort(String[] arr) {
        sort(arr, 0);
    }
    private static void sort(String[] arr, int start) {
        if (start < arr.length) {
            int smallestIndex = findSmallestIndex(arr, start);
            swap(arr, start, smallestIndex);
            sort(arr, start + 1);
        }
    }
    ```

---

<br />

## 3.3 Better JUnit

1. JUnit 除了 `AssertEquals` 之外，还有 `AssertFalse`, `AssertNotNull`,`fail`, ...

2. 使用 "test annotation"

    - 在每个用于测试的 method 前面加上 `@org.junit.Test`
    - 在 TestSort class 中，将所有需要被测试的 method 改为 non-static
    - 在 TestSort class 中移出 main() method.

3. 使用 "import statement"。考虑在文件头部加入

    ```java
    import org.junit.Test;
    import static org.junit.Assert.*;
    ```

    - 此后，所有 `@org.junit.Test` 可以简化为 `@Test`
    - 此后，所有 `org.junit.Assert.assertArrayEquals` 可简化为 `assertArrayEquals` (其余同理)

4. **(Test-Driven Development)** TDD 是一个开发过程。步骤如下

    - 确定一个新功能
    - 为该功能编写单元测试
    - 写代码之前运行测试，保证其应该失败
    - 编写代码，通过测试
    - 可选：重构代码使其更快

