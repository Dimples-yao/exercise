package seventeen;

import fifteen.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/*p461*/
class Government implements Generator<String>{
    String[] foundation = "strange women lying in ponds distributing swords is no basis for a system of government".split(" ");
    private int index;
    public String next() {
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);
    }
}
