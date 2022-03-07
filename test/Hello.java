package test;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("-------------");

        for (String s : args) {
            System.out.println(s);
        }

//        Dog00.makeNoise();
        Dog00 d = new Dog00();
        d.w = 12;
        d.makeNoise();
    }
}
