package eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*p243*/
class ReversibleArrayList<T> extends ArrayList<T>{
    public ReversibleArrayList(Collection<T> c){super(c);}
    public Iterable<T> reversed(){
        return new Iterable<T>(){
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size()-1;

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    public boolean hasNext() {
                        return current>-1;
                    }

                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}

public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        for (String s:ral)
            System.out.println(s+" ");
        System.out.println();
        for (String s:ral.reversed())
            System.out.println(s+" ");
    }
}
