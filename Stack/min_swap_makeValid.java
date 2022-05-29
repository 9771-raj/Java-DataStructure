package Stack;
import java.util.*;
public class min_swap_makeValid {
    public static void main(String[] args) {
        String str="]]][][[[";
        Stack<Character> stack=new Stack<>();
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (stack.empty() && ch=='['){
                stack.push(ch);
            }
            else if (!stack.empty() && ch=='['){
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ch==']'){
                stack.pop();
                count+=1;
            }
        }
        System.out.println(stack);
        int ans=(str.length()-2*count)/2;
        System.out.println(ans);

    }
}
