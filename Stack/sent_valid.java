package Stack;

import java.util.*;
import java.util.Stack;

public class sent_valid {
    public static void main(String[] args) {
        String s="a)b((c)d)))))asdf";
        Stack<Integer> stack=new Stack<>();
        //Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            if(ch == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }
        System.out.println(stack);
        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for(int i=0;i<s.length();i++)
            if(!set.contains(i))
                result.append(s.charAt(i));

        System.out.println(result.toString());
    }
}
