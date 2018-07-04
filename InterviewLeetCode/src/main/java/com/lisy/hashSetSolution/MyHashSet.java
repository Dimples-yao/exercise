package com.lisy.hashSetSolution;

/**
 * @author Lisy
 * @version 1.0
 * @Description
 * @Date 2018/7/4
 */
public class MyHashSet {

    int[] map;

   /** Initialize your data structure here. */
    public MyHashSet() {
        map = new int[1000000];
    }

    public void add(int key) {
        map[hash(key)] = key+1;
    }

    public void remove(int key) {
        map[hash(key)] = 0;
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return map[hash(key)]!=0;
    }

    public int hash(int key){
        return key;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */