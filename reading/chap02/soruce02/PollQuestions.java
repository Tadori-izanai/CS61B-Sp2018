package reading.chap02.soruce02;

public class PollQuestions {
    public static void main(String[] args) {
        // Demo1
        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);
        System.out.println(b);
        // demo2
        int x = 5;
        int y;
        y = x;
        x = 2;
        System.out.println(x);
        System.out.println(y);

        /*
        weigh: 5, tusk size: 8.30
        weigh: 5, tusk size: 8.30
        2
        5
         */
    }
}
