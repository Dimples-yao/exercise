package seventeen;

import fifteen.Generator;

import java.util.ArrayList;

/*p461*/
public class CollectionData<T> extends ArrayList{
    public CollectionData(Generator<T> gen,int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
