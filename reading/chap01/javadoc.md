## Overview of Javadoc

> Reference: https://en.wikipedia.org/wiki/Javadoc

- 类声明示例

    ```java
    // import statements
    
    /**
     * @author lxl u178a4@outlook.com (姓名和邮箱)
     * @version 1.6					(程序当前版本号)
     * @since 1.2					(加入该类时程序的版本号)
     */
    
    public class Test {
        // class body
    }
    ```

- 任何 import 语句必须在类声明之前

---

```java
/**
 * 简短的单行描述
 * <p>
 *     更长一些的描述写在此处
 * </p>
 * 在 HTML 段落分隔的连续段落中还可以有更多注释
 *
 * @param variable 描述文本
 * @return 描述文本
 */
public int methodName(int x) {
    return x;
}
```

- 所有的 Javadoc 都被视为 HTML，因此有多个段落部分由 `<p>` 分隔

---

```java
/**
 * 对变量的描述
 */
public int debug = 0;
```

- 不建议的做法

    ```java
    /**
     * ...
     */
    public int x, y;
    ```

    