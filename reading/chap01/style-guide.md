## Style Guide

> Reference: https://sp19.datastructur.es/materials/guides/style-guide.html

### 1 Whitespace 空白

1. Each file must end with a newline sequence
2. 使用 `' '` 来缩进，而不是 `'\t'`
3. 每行末尾不要有空格
4. 不要放空格的地方有：
    - Around the `<` and `>` within a generic type designation (规范示例：`List<Integrate>`)
    - 前缀运算符之后，如 `!`, `-`, `++`, etc
    - After `(` 或者 before `)`
    - After `.`
    - When you are lonely
5. 要放空格的地方
    - After 逗号、分号、type casts (规范示例：`(String) x`)
    - Around 二元运算符，如 `+`, `*`
    - Around 赋值运算符，如 `=`, `+=`
    - Around `? :` (规范示例：`x > 0 ? x : -x`)
    - Around 关键字 assert, catch, do, else, finally, for, if, return, synchronized, try, while

---

### 2 Indentation 缩进

1. Indentation step: 4 space

2. if 语句

    ```java
    if (x > 0) {
        r = -x;
    } else {
        r = x;
    }
    ```

3. switch 语句

    ```java
    switch (op) {
        case '+':
            addOpnds(x, y);
            break;
        default:
            ERROR();
    }
    ```

4. Indent continued lines by the basic indentation step.

---

### 3 Braces 括号

1. 在所有的 if, while, do, for 语句都使用 `{}`

2. 把 `}` 和 else, finally, catch 放在同一行

    ```java
    if (x > 0) {
        r = -x;
    } else {
        r = x;
    }
    ```

3. `{` 通常放在 `if`, `for`, `while`, `switch`, `do`, method 头 or class header that contains it
    - 如果行太长，可以把 `{` 放在下一行（单独的一行），不要缩进

---

### 4 Comments 注释

1. 对于 methods，应使用 Javadoc 注释，解释其行为和参数（使用 `@param` tag or otherwise）
2. 对于返回值不是 `void` 的 methods，需要在 Javadoc 中使用 `@return` tag 来描述 (或用包含 "return" 的短语来描述)
3. 每个 Javadoc 必须以一个完整的句子开始 (大写字母开头，句号结尾)

---

### 5 Names 命名

1. static final constants 名必须全部是大写的 (e.g `RED`, `DEFAULT_NAME`)
2. parameters, local variables, and methods: 小写字母开头，或由单个大写字母组成
3. types (classes) (包括 type parameters): 必须大写字母开头
4. packages: 必须小写字母开头
5. instance variables, non-final class (static) variable: 以小写字母或下划线开头

---

### 6 Impoorts 

1. 不要使用 `import PACKAGE.`
    - 例外：`java.lang.Double`, `org.junit.Assert.`, `import static CLASS`
2. 不要两次 import 相同的 class 或者 static member
3. 不要 import 不需要使用的 classes 或者 members

---

### 7 Assorted Java Style Conventions 各种 Java 风格的约定

1. 写数组的时候，将 `[]` 写在元素类型之后 (`String[] names`, not `String names[]`)
2. methods, classes, fields 修饰符 (modifiers) 的书写顺序
    - public, protected, private
    - abstact, static
    - final, transient, volatile
    - synchronized
    - native
    - strictfp

... (待完善)

---

### 8 Avoiding Error-Prone Constructs

...(待完善)

---

### Limits

1. 文件行数上限：2000 lines
2. 行字符上限：100 characters
3. method 行数上限：80 lines
4. method 参数个数上限：8 parameters
5. 所有文件包含且仅包含一个 outer class (nested classes are OK)

