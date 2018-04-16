package seventeen;

import fifteen.Generator;
import java.util.Iterator;

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{

    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++,""+letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return number<size;
            }

            public void remove() {throw new UnsupportedOperationException();}


            public Integer next() {
                return number++;
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),11));
    }
}
