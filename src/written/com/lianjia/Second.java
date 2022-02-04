package written.com.lianjia;

import java.util.*;

public class Second {

    /**
     * 对字符串中元素进行重排序
     * 此外还可以在该方法对元素进行去重等
     * @param str  原字符串
     * @return  目标字符串
     */
    public static String stringFilter(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    /**
     * 得到组合结果
     * @param num   从N个数中选取num个数
     * @param str   包含Ng个元素的字符串
     * @return  组合结果
     */
    public static List<String> getCombinationResult(int num, String str) {
        List<String> result = new ArrayList<String>();
        if (num == 1) {
            for (char c : str.toCharArray()) {
                result.add(String.valueOf(c));
            }
            return result;
        }
        if (num >= str.length()) {
            result.add(str);
            return result;
        }
        int strlen = str.length();
        for (int i = 0; i < (strlen - num + 1); i++) {
            List<String> cr = getCombinationResult(num - 1, str.substring(i + 1));//从i+1处直至字符串末尾
            char c = str.charAt(i);//得到上面被去掉的字符，进行组合
            for (String s : cr) {
                result.add(c + s);
            }
        }
        return result;
    }

    public static boolean isTri(String str){
        int a = Integer.parseInt(str.substring(0,1));
        int b = Integer.parseInt(str.substring(1,2));
        int c = Integer.parseInt(str.substring(2,3));
        if((a+b)>c&&(a+c)>b&&(b+c)>a){
            return true;
        }else{
            return false;
        }
    }

    public static int getMax(int[] maxInt){
        int tem = 0;
        for (int i=0;i<maxInt.length;i++){
            if (tem<maxInt[i])
                tem = i;
        }
        return tem;
    }

    public static int[] delete(int index,int array[]){
        //根据删除索引，把数组后面的向前移一位
        for(int i=index;i<array.length;i++){
            if(i!=array.length-1){
                array[i]=array[i+1];
            }else{//处理最后一位超出情况
                array[i]=array[i];
            }
        }
        return array;
    }

    /**
     * 得到所有三角形
     */
    public static int getMin(int[] ns){
        String str = "";
        for (int i=0;i<ns.length;i++){
            str = str+String.valueOf(ns[i]);
        }
        int[] tagN = new int[ns.length];//用于存储每次形成三角形时，每个数用到了几次
        if (ns.length<3){
            return ns.length;
        }
        List<String> cr = getCombinationResult(3, stringFilter(str));
        for(String s: cr){
            boolean tag = isTri(s);
            if (tag){
                tagN[Integer.parseInt(s.substring(0,1))-1]++;
                tagN[Integer.parseInt(s.substring(1,2))-1]++;
                tagN[Integer.parseInt(s.substring(2,3))-1]++;
            }
        }

        boolean yes = false;//记载tagN中是否全部为0

        for (int i:tagN){
            if (i!=0)
                yes = false;
        }

        if (yes){
            return tagN.length;
        }

        int theI = getMax(tagN);
        int[] nextNs = new int[tagN.length-1];
        nextNs = delete(theI,ns);

        getMin(nextNs);

        return 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ns = new int[n];
        for (int i=0;i<n;i++){
            ns[i]=i+1;
        }
        System.out.println(n-getMin(ns));
    }
}
