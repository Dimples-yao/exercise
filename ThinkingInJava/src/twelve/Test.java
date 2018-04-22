package twelve;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private int currentEvenvalue = 0;
    private Lock lock = new ReentrantLock();
}
