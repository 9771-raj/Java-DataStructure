package Stack;
import java.util.*;
public class min_add_make_valid {
    public static void main(String[] args) {
        String str="()()((((())(";
        Stack<Character> stack=new Stack<>();
        int count=0;

        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            //System.out.println(ch);
            //System.out.println(stack);
            if (stack.empty() && ch=='('){
                stack.push(ch);
            }
            else if (!stack.empty() && ch=='('){
                stack.push(ch);
            }
            else if (!stack.isEmpty() && ch==')'){

                stack.pop();
            }
            else if (stack.isEmpty() && ch==')'){
                count+=1;
            }
        }
        System.out.println(stack);
        System.out.println(count+stack.size());
    }
}
