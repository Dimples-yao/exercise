import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put(null,"22");
        System.out.println(map.containsKey(null));
        System.out.println(map.get(null));
    }
}
