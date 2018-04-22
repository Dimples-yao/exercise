package seventeen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastFailTest {
    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        new ThreadOne().run();
        new ThreadTwo().run();
    }

    private static void printAll(){
        System.out.println("");
        String value = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            value = (String) iterator.next();
            System.out.print(value+",");
        }
        System.out.println();
    }

    private static class ThreadOne extends Thread{
        public void run(){
            int i = 0;
            while (i<100){
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    private static class ThreadTwo extends Thread{
        @Override
        public void run() {
            int i = 100;
            while (i<200){
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

}
