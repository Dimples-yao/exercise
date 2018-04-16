package eleven;

public class IntCacheDemo {
    public static void main(String[] args) {
        Integer a = 2013;
        Integer b = 2013;
        if (a==b) System.out.println("a==b");
        else if (a.equals(b)) System.out.println("a.equals(b)");
        Integer c = 100;
        Integer d = 100;
        if (c==d) System.out.println("c==d");
        else if(c.equals(d)) System.out.println("c.equals(d)");

        int e = 2013;
        int f = 2013;
        if (a==f) System.out.println("a==f");

        int i = 100;
        int g = 100;
        if (c==g) System.out.println("c==g");

    }
}
