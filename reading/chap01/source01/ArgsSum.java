package reading.chap01.source01;

public class ArgsSum {
    public static void main(String[] args) {
        int sum = 0;
        for (String s : args)
            sum += Integer.parseInt(s);
        System.out.println(sum);
    }
}
