package assignments.proj0.source;

public class Triangle {
    public static void main(String[] args) {
        StdDraw.setScale(-0.05, 1.05);

        double t = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(1, 0, .5, t);
        StdDraw.line(.5, t, 0, 0);
    }
}
