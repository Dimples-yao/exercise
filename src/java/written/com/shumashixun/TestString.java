package java.written.com.shumashixun;

public class TestString {
    public TestString(String str) {
        this.str = str;
    }

    String str = "lisy";

    public String getStr (){return this.str;}

    public static void main(String[] args) {
        TestString testString = new TestString("njh");
        System.out.println(testString.getStr());
    }
}
