package java.leetcode.com.hashSetSolution;

/**
 * @author Lisy
 * @version 1.0
 * @Description
 * @Date 2018/7/4
 */
public class MyHashSet {

    int[] set;

   /** Initialize your data structure here. */
    public MyHashSet() {
        set = new int[1000000];
    }

    public void add(int key) {
        set[hash(key)] = key+1;
    }

    public void remove(int key) {
        set[hash(key)] = 0;
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return set[hash(key)]!=0;
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