package lisy.written.com.shumashixun;

import java.util.Set;
import java.util.TreeSet;

public class C1 implements Comparable {
    String attr1 = "attr2";
    static int attr2 = 2;

    public C1(String attr1,int attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    public String getAttr1(){return attr1;}

    public void setAttr1(String attr1){this.attr1=attr1;}

    public int getAttr2(){return attr2;}

    public void setAttr2(int attr2){this.attr2 = attr2;}

    @Override
    public int compareTo(Object that) {
        return this.attr2 - ((C1)that).getAttr2();
    }

    @Override
    public String toString() {
        return "attr1="+attr1+",attr2="+attr2+";";
    }

    public boolean equals(Object that){
        return attr1 == ((C1)that).getAttr1();
    }

    @Override
    public int hashCode() {
        return attr2;
    }

    public static void main(String[] args) {
        Set<C1> set = new TreeSet<>();
        set.add(new C1("attr4",4));
        set.add(new C1("attr5",5));
        set.add(new C1("attr3",3));
        set.add(new C1("attr6",6));
        System.out.println(set.toString());
    }

}
