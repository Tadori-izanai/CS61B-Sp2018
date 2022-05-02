package reading.chap04.source;

public class WordUtils {
    public static String longest(SLList<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > list.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }

    public static String longest(AList<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > list.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }


    public static void main(String[] args) {
        SLList<String> someList = new SLList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(longest(someList));
    }
}
