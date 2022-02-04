package lisy.written.com.huawei;


import java.util.Scanner;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int val = map.get(ch);
                map.put(ch, ++val);
            }else {
                map.put(ch, 1);
            }
        }

        String resultString = "";
        while(resultString.length()<str.length()){
            for(Character key : map.keySet()){
                if(map.get(key)>0){
                    resultString+=String.valueOf(key);
                    int val = map.get(key);
                    map.put(key, --val);
                }
            }

        }

        System.out.println(resultString);

    }
}
