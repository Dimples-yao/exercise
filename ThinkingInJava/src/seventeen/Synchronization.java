package seventeen;

import java.util.*;

public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedList(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        Map<String,String> map = Collections.synchronizedMap(new HashMap<String, String>());
    }
}
