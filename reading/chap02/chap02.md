# 2 Lists

## 2.1 Mystery of the Walrus

### Bits

1. 考虑以下的声明

    ```java
    char c = 'H';
    int x = c;		// print x 会得到 72
    ```

    此时 `x` 和 `c` 都包含了相同的位。打印时，Java 解释器会根据它们的变量类型不同，作不同的处理方式。

    > Java 中的 8 种 primitive types: byte, short, int, long, float, double, boolean, char.
    >
    > 其他的一切类型 (包括 arrays), 称为 **reference type**.

2. **Declarating a Variable (Simplified)** 当声明了

    ```java
    int x;
    double y;
    ```

    Java 将决定用计算机中的 32 bits 来存储 `x`，用 64 bits 来存储 `y` (Java 中无法访问具体的地址，unlike C).

    - **Golden Rule of Equals (GRoE)** 当写 `b = a` 时，Java 解释器将 `a` 中的位复制到 `b`

### Reference Type

3. 考虑如下的 Class

    ```java
    public static class Walrus {
        public int weight;
        public double tuskSize;
        public Walrus(int w, double ts) {
            weight = w;
            tuskSize = ts;
        }
    }
    ```

    - 当使用 `new Walrus(1000, 8.3)` 时，则创造了一个 96 bits (实际会更大一些) 的 object

    <img src="chap02.assets/image-20220309142018630.png" alt="image-20220309142018630" style="zoom:50%;" />

4. **Reference Variable Declaration**. 当声明了一个 reference type 的变量，如 `Walrus someWalrus;`，Java 将分配一个 64 bits 的 box 来存储其。

    - 这个 64 bits 的 box 用于存储 walrus object 的地址！

    - 考虑

        ```java
        Walrus some Walrus;					// 创建了一个 64 bits 的 box
        someWalrus = new Walrus(1000, 0.3);   // 创建了一个新的 Walrus, 其存储地址由 new 关键字返回 (返回一些位)
        // 根据 GRoE, 这些位被复制到了 someWalrus 的 box 中
        ```

    - 参考下图

    <img src="chap02.assets/image-20220309143132856.png" alt="image-20220309143132856" style="zoom: 67%;" />

    - 也可以把特殊值 `null` 赋给 reference type 变量。如 `someWalrus = null`. 则其位全变成 0.

5. **Box and Pointer Notation**. 

    - 如果地址全为 0，则用 null 来表示其。
    - 对于 non-zero，用指向对象的实例箭头表示。

    <img src="chap02.assets/image-20220309145230573.png" alt="image-20220309145230573" style="zoom:50%;" />

### Parameter Passing

> argument: 实参 (actual parameter)。parameter: 形参 (formal parameter)

6. 在传递参数时，也只是复制了位 (GRoE 也适用于参数传递)。

    - 复制位常称为 "pass by value", 在 Java 中总是 pass by value,

    - 例 (观察下列 `walrus` 和 `x` 的变化)

        ```java
        public class PassByValueFigure {
            public static void main(String[] args) {
                Walrus walrus = new Walrus(3500, 10.5);
                int x = 5;
                doStuff(walrus, x);
                System.out.println(walrus);
                System.out.println(x);
            }
            public static void doStuff(Walrus w, int x) {
                w.weight -= 100;
                x -= 5;
            }
        }
        ```

### Instantiation of Arrays

7. 存储 array 的变量也是 reference variables (都使用 64 bits 存储)。考虑

    ```java
    int[] x;						// Instantiating an array x
    x = new int[]{0, 1, 2, 95, 4};	  // new 创建了 5 个 32 bit 的 box, 并返回整个 object 的地址给 x.
    ```

    - 丢失与地址对应的位，则很可能丢失对象。如让 `x = 0`.

### IntLists

8. 一个非常基本的 list 实现

    ```java
    public class IntList {
        public int first;
        public IntList rest;
        public IntList(int f, IntList r) {
            first = f;
            rest = r;
        }
    }
    ```

    - 考虑 make 一个三个数 5, 10, 15 的 list，可以

        ```java
        IntList L0 = new IntList(5, null);
        L0.rest = new IntList(10, null);
        L0.rest.rest = new IntList(15, null);
        ```

        也可以考虑从后往前构建 (此时有更简洁的代码)

        ```java
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        ```

    - 可以考虑在 IntList class 中添加辅助 method 来执行基本任务 (面向对象的策略)

9. （size() and iterativeSize() methods）考虑在 IntList 中添加一个方法，可以返回 `L` 中的 items 数量

    - 可以使用递归的方法

        ```java
        public int size() {
            if (this.rest == null)
                return 1;
            return (this.rest.size() + 1);
        }
        ```

        - 不设置 `if (this == null) return 0;` 是因为当 `L` 为空时，调用 `L.size()` 则会受到 NullPointer 的 error.

    - 也可以不采用 recursion，而采用 loop

        ```java
        public int iterativeSize() {
            int count = 0;
            for (IntList iter = this; iter != null; iter = iter.rest)
                count++;
            return count;
        }
        ```

        - 注意应当引入一个变量 `iter`，而不能直接 `this.rest`

10. (get() methods) 考虑在 IntList 中添加一个方法，可以返回 `L` 中 i-th item 的值

    ```java
    public int iterativeGet(int i) {
        IntList p = this;
        while (i > 0) {
            p = p.rest;
            i--;
        }
        return p.first;
    }
    // 也可以采用递归
    public int get(int i) {
        if (i == 0)
            return first;
        return rest.get(i - 1);
    }
    ```

    


