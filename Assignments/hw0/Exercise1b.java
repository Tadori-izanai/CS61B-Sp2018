package Assignments.hw0;

public class Exercise1b {
    public static void main(String[] args) {
        DrawTriangle(10);
    }

    public static void DrawTriangle(int N) {
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++)
                System.out.print('*');
            System.out.println();
        }
    }
}
