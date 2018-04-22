package seventeen;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    static final int SIZE = 997;
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode())%SIZE;
        if (buckets[index] == null) buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K,V>> bucket = new LinkedList<MapEntry<K, V>>();
        MapEntry<K,V> pair = new MapEntry<K, V>(key,value);
        boolean fouond = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                fouond = true;
                break;
            }
        }
        if (!fouond) buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode())%SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K,V> iPair:buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Entry<K, V>>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket == null) continue;
            for (MapEntry<K,V> mpair:bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
