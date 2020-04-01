package com.lisy.hashMapSolution;

/**
 * @author Lisy
 * @version 1.0
 * @Description
 * @Date 2018/7/4
 */
public class MyHashMap {
    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000000];
    }

    /** value will always be positive. */
    public void put(int key, int value) {
        map[getHash(key)] = value+1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (map[getHash(key)]==0)
            return -1;
        return map[getHash(key)]-1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[getHash(key)] = 0;
    }

    public int getHash(int key){
        return key;
    }

}
