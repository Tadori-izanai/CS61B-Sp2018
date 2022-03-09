package reading.chap02.soruce02;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // 尝试编写 size() method
    public int size() {
        if (this.rest == null)
            return 1;
        return (this.rest.size() + 1);
    }

    // 尝试编写 iterativeSize() method
    public int iterativeSize() {
        int count = 0;
        for (IntList iter = this; iter != null; iter = iter.rest)
            count++;
        return count;
    }

    // 尝试编写 get() method 来获取 i-th item fo this IntList
    public int iterativeGet(int i) {
        IntList p = this;
        while (i > 0) {
            p = p.rest;
            i--;
        }
        return p.first;
    }
    // 采用递归
    public int get(int i) {
        if (i == 0)
            return first;
        return rest.get(i - 1);
    }



    public static void main(String[] args) {
        IntList L0 = new IntList(5, null);
        L0.rest = new IntList(10, null);
        L0.rest.rest = new IntList(15, null);

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println("L.get(1): " + L.get(2));
    }
}
