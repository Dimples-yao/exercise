package com.PinDuoDuo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int height = sc.nextInt();
            if (map.containsKey(sc.nextInt()))
                map.put(height, map.get(height) + 1);
            else
                map.put(height, 1);
        }
//			list.add(sc.nextInt());
        sc.close();
        int sum = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int height = entry.getKey();
            if (height <= 150) {
                int count = entry.getValue();
                if (count != 0) {
                    int add = 300 - height;
                    while (add >= height && count > 0) {
                        if (map.get(add) != null) {
                            int v = map.get(add);
                            if (v > 0) {
                                v--;
                                count--;
                                sum++;
                            }
                            map.put(add, v);
                            if (v == 0)
                                add--;
                        } else {
                            add--;
                        }
                    }
                }
            }

        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                sum += entry.getValue();
        }

        System.out.println(sum);

    }

}