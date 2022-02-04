package written.com.kuaishou;

import java.util.Random;

public class Second_1 {
    public static void main(String[] args) {
        System.out.println(getRandom());
    }

    public static int getRandom(){
        Random random = new Random();
        int[] result = {1,3,3,3,6,6,6,6,6,6};
        return result[random.nextInt(11)];
    }

}
