package cbhb.com.base;

/**
 * @author lishaoyao
 * @date 2021/12/15 9:56 AM
 * @describe
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Demo2.url.hashCode():" + Demo2.url.hashCode());

        /*Demo2 demo2 = new Demo2();
        System.out.println("demo2.url1.hashCode():" + demo2.url1.hashCode());
        System.out.println("demo2.url1:" + demo2.url1);

        Demo2 demo3 = new Demo2();
        System.out.println("demo3.url1.hashCode():" + demo3.url1.hashCode());
        System.out.println("demo3.url1:" + demo3.url1);*/
        getDemo1();
        getDemo2();
    }

    public static void getDemo1(){
        Demo2 demo2 = new Demo2();
        System.out.println("demo2.url1.hashCode():" + demo2.url1.hashCode());
        System.out.println("demo2.url1:" + demo2.url1);
    }
    public static void getDemo2(){
        Demo2 demo2 = new Demo2();
        System.out.println("demo2.url1.hashCode():" + demo2.url1.hashCode());
        System.out.println("demo2.url1:" + demo2.url1);
    }
}
