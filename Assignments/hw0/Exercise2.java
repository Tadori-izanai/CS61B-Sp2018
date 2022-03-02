package Assignments.hw0;

public class Exercise2 {
    public static int max(int[] m) {
        int maxVal = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > maxVal)
                maxVal = m[i];
        }
        // 以下是等价的写法
//        for (int j : m) {
//            if (j > maxVal)
//                maxVal = j;
//        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}
