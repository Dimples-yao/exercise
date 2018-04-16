package seventeen;

import fifteen.Generator;

import java.util.LinkedHashMap;
/*p463*/
public class MapData<K,V> extends LinkedHashMap {
    //使用单一的Generator<Pair<k,v>>
    public MapData(Generator<Pair<K,V>> gen ,int quantity){
        for (int i = 0; i < quantity; i++) {
            Pair<K,V> p = gen.next();
            put(p.key,p.value);
        }
    }
    //两个分离的Generator
    public MapData(Generator<K> genK,Generator<V> genV,int quanlity){
        for (int i = 0; i < quanlity; i++) {
            put(genK.next(), genV.next());
        }
    }
    //一个Generator和一个常量值
    public MapData(Generator<K> genK,V value,int quanlity){
        for (int i = 0; i < quanlity; i++) {
            put(genK.next(),value);
        }
    }
    //一个Iterable(包括任何Collection)和一个Generator
    public MapData(Iterable<K> genK,Generator<V> genV){
        for (K key:genK){
            put(key,genV.next());
        }
    }
    //一个Iterable和一个单一值
    public MapData(Iterable<K> genK,V value){
        for (K k:genK){
            put(k,value);
        }
    }


    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData<K, V>(gen,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity){
        return new MapData<K, V>(genK,value,quantity);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
        return new MapData<K, V>(genK,genV);
    }

    public static <K,V> MapData<K,V> map (Iterable<K> genK,V value){
        return new MapData<K, V>(genK,value);
    }

}
