# 1 Introduction to Java

## 1.1 Essentials

1. Hello world

    ```java
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
    }
    ```

    - 使用关键字 `public class` 来类声明
    - Java 中所有代码写在 class 中
    - 运行的代码在 `mian` 方法中
    - Statement 必须以分号结束

2. Java 程序的运行步骤

<img src="chap01.assets/image-20220303091606140.png" alt="image-20220303091606140" style="zoom:50%;" />

- Java 编译器 javac

- Java 解释器 java

- 终端命令

    ```shell
    $ javac HelloWorld.java
    $ java HelloWorld
    ```

3. **(Static Typing)** Java 中所有变量都有 **static type**

    - Java 编译器会执行 static type check

    - 一个变量的类型不可改变，例如

        ```java
        int x = 0;
        x = "horse";	// 报错（运行之前编译器就拒绝了这个程序）
        ```

    - Java 是 strongly typed

        ```java
        String h = 5 + "horse";	// 成功, 因为 Java 可以将数字和字符串拼接为一个字符串
        int h = 5 + "horse";	// 给编译错误
        System.out.println(5 + "10");	// 输出 510
        System.out.println(5 + 10);		// 输出 15
        ```

    > Python 中 `5 + "horse"` 会报错，因为无法确定其是数字还是 String

4. **(Function)** 因为 Java 代码都是类的一部分，所以必须定义 function（method）

    ```java
    // 定义一个函数, 示例
    public static int larger(int x, int y) {
        if (x > y)
            return x;
        return y;
    }
    ```

5. Features of good coding style (See [style guide](style-guide.md))

    - Consistent style (Spacing, naming, brace style)
    - Size (lind width 不宽, source file length 不长)
    - Descriptive naming
    - Avoidance of repetitive code
    - Comments

    > Golden Rule: 写容易让 stranger 理解的代码。
    >
    > 可以承担轻微的性能损失，为了更易于理解

6. Through experience and exposure to others' code, you will get a feeling for when comments are most appropriate.

    - 所有 methods 和几乎所有 classes 应使用 Javadoc 格式来注释

    - 示例 without tags

        ```java
        public class LargerDemo {
            /** Returns the large of x and y. */
            public static int larger(int x, int y) {
                if (x > y)
                    return x;
                return y;
            }
            public static void main(String[] args) {
                System.out.println(larger(8, 10));
            }
        }
        ```
        
    - 详见 [Javadoc.md](javadoc.md)
    

---

<br />

## 1.2 Defining ans Using Classes

### Static vs. Non-Static Methods

1. **(Static Methods)** 考虑写一个类文件 Dog.java

    ```java
    public class Dog {
        public static void makeNoise() {
            System.out.println("Bark!");
        }
    }
    ```

    因为其没有 `main` method，其不能做任何事情。但是可以考虑写另一个 class `DogLauncher` (写到类文件 DogLauncher.java 中)

    ```java
    public class DogLauncher {
        public static void main(String[] args) {
            Dog.makeNoise();
        }
    }	// 运行其即可狗叫
    ```

    - `DogLauncher` 称为 `Dog` 的 client (客户端)。
    - 有时，可以直接在 Dog class 中添加 main method
    - 有时，可以创建一个像 DouLauncher class 这样的客户端则更好

2. **(Instance Variables and Object Instantiation)** 实例变量和对象实例化  
    Class can be instantiated (实例化). Instances (实例) can hold data. 我们考虑修改 Dog

    ```java
    public class Dog {
        // 注意没有 static
        public int weighInPounds;			// 称为 instance variables
        // non-static method (也称为 instance method)
        public void makeNoise() {
            if (weighInPounds < 10)
                System.out.println("yip!");
            else if (weighInPounds < 30)
                System.out.println("bark!");
            else
                System.out.println("woof!");
        } // 如果一个 method 被一个 instance of the class 调用, 则此 method 必须时 non-static
    }
    ```

    在 DogLauncher 的 main method 中创建一只 Dog

    ```java
    Dog d;
    d = new Dog();
    d.weighInPounds = 20;
    d.makeNoise();					// 获得 bark!
    ```

    - Java 中的 Object is an instance of any class.
    - Dog class 有自己的 variables -- 称其为 instance variables 或 non-static variables. (它们必须在 class 中声明)
    - 在 Dog class 中创建的 methods 没有 `static` 关键字 -- 称其为 instance methods 或 non-static methods
    - 要调用 `makeNoise()` method，必须先使用关键字 `new` 来 instantiate a Dog. (我们调用的是 `d.makeNoise()` 而不是 `Dog.makeNoise()`)
    - once an object has been instantiated, it can be assigned to a declared variable of the appropriate type. (e.g. `d = new Dog()`.)
    - 一个 class 中的 variables 和 methods 被称为 class 的 member.
    - 使用 `.` 运算符来访问 class 的 member.

3. **(Constructors in Java)** 给我们的 Dog class 一个 constructor

    ```java
    public Dog(int w) {
        weighInPounds = w;
    }	// 写在 Dog class 中
    public Dog() { }	// 还可以重载 (
    ```

    在 DogLauncher 的 main method 中使用构造函数

    ```java
    Dog d2 = new Dog(51);
    d2.makeNoise();			// 获得 woof!
    ```

    - 每当使用 `new` 和单个整数参数创建 Dog 时，都会调用具有 signature `public Dog(int w)` 的 constructor.

4. 给出一些术语 (declaration, instantiation, assignment)

    ```java
    Dog smallDog;				// Declaration of a Dog variable
    new Dog(20);				// Instantiation of the Dog class as a Dog Obj
    small Dog = new Dog(5);		 // Instantiation and Assignment
    Dog hugeDog = new Dog(150);	 // Declaration, Instantiation and Assignment
    hugeDog.makeNoise();
    ```

5. **(Array Instantiation, Arrays of Objects)** Java 中，数组也使用 `new` 来进行 istantiation

    ```java
    int[] someArray = new int[5];
        someArray[0] = 3;
        someArray[1] = 4;
    ```

    也可以创建 instantiated objects 的数组
    
    ```java
    Dog[] dogs = new Dog[2];	// new 一个 Dog 数组
    dogs[0] = new Dog(8);		// new 一个实际的 Dog
    dogs[1] = new Dog(20);
    for (Dog d : dogs)
        d.makeNoise();
    ```

---

### Class Methods vs. Instance Methods

6. Java 允许定义的两种 method 类型

    - Class Method，又称 static method
    - Instance Method，又称 non-static method

    两者的区别

    - Instance method 只能用 a specific instance of a class 来调用 (只能用实例对象来调用)
    - Clas Methods are actions that are taken by the class itself (一般用类名来调用)

7. 来考虑 Dog 的体重比较。

    - 一种方法是添加一个 static method 来比较 dogs

        ```java
        public static Dog maxDog(Dog d1, Dog d2) {
            if (d1.weighInPounds > d2.weighInPounds)
                return d1;
            return d2;
        }
        ```

        其使用类名 `Dog` 来调用

        ```java
        Dog d = new Dog(15);
        Dog d2 = new Dog(100);
        Dog dogMax = Dog.maxDog(d, d2);
        ```

    - 另一种方法是使用 non-static method

        ```java
        public Dog heavierDog(Dog d2) {
            if (this.weighInPounds > d2.weighInPounds)  // this.weighInPound 可简化为 weighInPound
                return this;	// this 关键字来引用当前实例
            return d2;
        }
        ```

        其使用特定的实例变量 `d2` 来调用

        ```java
        dogMax = d2.heavierDog(d);
        dogMax.makeNoise();
        System.out.println(dogMax.weighInPounds);
        ```

8. **(static variables)** static variables 是 class 本身的固有的属性，而不是 instance 的属性。例如

    ```java
    public class Dog {
        public int weighInPounds;							  // instance variable
        public static String binomen = "Canis familiaries";		// static variable
        // ...
    }
    ```

    应该使用类名 `Dog` 来访问 static variabels

    ```java]
    System.out.println(Dog.binomen);
    ```


---

<br />

## public static void main(String[] args)

1. 将此 signature 分解

    - `public` 目前所有的 method 均为 public，先不讨论
    - `static` static method, 不与任何特定的实例相关
    - `main` name
    - `String[] args` parameter

2. **(Command Line Arguments)** 给出一个例子

    ```java
    public class ArgsDemo {
        public static void main(String[] args) {
            if (args.length > 0)
                System.out.println(args[0]);
        }
    }
    ```

    注意和 C 不同，类名 `ArgsDemo` 不算命令行参数。运行示例

    ```shell
    $ java ArgsDemo these are command line arguments
    these
    ```

    > 练习：写一个程序，用于输出所有命令行参数之和
    >
    > ```java
    > public class ArgsSum {
    >        public static void main(String[] args) {
    >            int sum = 0;
    >            for (String s : args)
    >                sum  += Integer.parseInt(s);			// 调用 Integrate 类的 static method
    >            System.out.println(sum);
    >        }
    > }
    > ```
    >
    > - 注意 String 向 int 转换

---

<br />

## Use Libraries

