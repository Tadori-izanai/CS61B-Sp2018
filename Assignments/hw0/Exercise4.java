package Assignments.hw0;

public class Exercise4 {
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        // Should print: [4, 8, -3, 13, 9, 4]
        System.out.println(java.util.Arrays.toString(a));   // 打印出 a 中所有元素

        // another example
        int[] another = {1, -1, -1, 10, 5, -1};
        n = 2;
        windowPosSum(another, n);
        System.out.println(java.util.Arrays.toString(another));
    }

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0)
                continue;
            for (int j = 1; j <= n; j++) {
                if (i + j >= a.length)
                    break;
                a[i] += a[i + j];
            }
        }
    }
}
