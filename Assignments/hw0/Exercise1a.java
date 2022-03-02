package Assignments.hw0;

public class Exercise1a {
    public static void main(String[] args) {
        int LINES = 5;
        for (int row = 1; row <= LINES; row++) {
            for (int col = 1; col <= row; col++)
                System.out.print('*');
            System.out.println();
        }
    }
}
