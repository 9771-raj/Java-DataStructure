package Stack;

import java.util.Arrays;
import java.util.Stack;

public class remove_k_digits {
    public static void main(String[] args) {
        String str="14301620";
        int k=4;
        Stack<Character> stack=new Stack<>();
        stack.push(str.charAt(0));
        //int[] ans=new int[str.length()];

        for (int i = 1; i <str.length(); i++) {
            while (!stack.isEmpty() && str.charAt(i)<stack.peek() && k>0){
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || str.charAt(i)!='0') {
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty() && k-->0){
            stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println('0');
        }
        char[] ans=new char[stack.size()];
        int n=stack.size();
        while (!stack.empty()){
            ans[n-1]=stack.pop();
            n--;
        }
        Arrays.toString(ans);

        System.out.println(ans);
    }
}
