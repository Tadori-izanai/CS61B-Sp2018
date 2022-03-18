package reading.chap03.source03;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        // 进行判断
        if (!java.util.Arrays.equals(input, expected))  // 注意不可以是 (input != expected)
            System.out.println("Error! There seems to be a problem with Sort.sort().");

        // 逐个判断
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ".");
                break;
            }
        }

        // 使用 org.junit
        assertArrayEquals(expected, input);

        assertEquals(expected[0], input[0]);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        String expected = "an";
        String actual = Sort.findSmallest(input);
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }

//
//    public static void main(String[] args) {
////        testFindSmallest();
////        testSwap();
//        testSort();
//    }
}
