package java.written.com.jdjr;

import java.util.Scanner;
import java.util.Stack;

public class Third {

    public static String isComplete(String s){
        Stack<String> left=new Stack<String>();
        while (!s.isEmpty()){
            //取字符串首字母
            String character=s.substring(0,1);
            //剩余的字符串
            s=s.substring(1);
            if(character.equals("(")){
                //如果是左括号，则压入栈
                left.push(character);
            }else if(character.equals(")")){
                //首先检查栈是否为空
                if(left.isEmpty())
                    return "No";
                //弹出最后的左括号
                String leftChar=left.pop();
                //检查左右括号是否匹配
                if(character.equals(")")){
                    if(!leftChar.equals("("))
                        return "No";
                }
            }
        }
        //此时栈中不应该再有左括号
        if (left.size()==2){
            if (left.pop() == ")"&&left.pop()=="(")
                return "Yes";
            else return "No";
        }else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i=0;i<n;i++){
            strs[i] = scanner.nextLine();
        }
        for (int i=0;i<n;i++){
            System.out.println(isComplete(strs[i]));
        }
    }
}
