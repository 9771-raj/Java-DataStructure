package Stack;
import java.util.*;
public class asteroid_colloision {
    public static void main(String[] args) {
        int[] arr={3,-4,5,-1,6,7,-9,10};
        Stack<Integer> stack=new Stack<>();

        for (int as:arr){
            if (stack.isEmpty() || as>0){
                stack.push(as);
                System.out.println(stack);
                continue;
            }
            while (!stack.isEmpty() && stack.peek()>0 && as+stack.peek()<0){
                stack.pop();
            }
            if (stack.isEmpty() || (stack.peek()<0 && as<0 )){
                stack.push(as);
            }
            else if (as+stack.peek()==0){
                stack.pop();
            }
        }
        int[] ans=new int[stack.size()];
        int n=stack.size()-1;
        for (int i = n; i >=0 ; i--) {
            ans[i]=stack.pop();
        }
        System.out.println(Arrays.toString(ans));
    }
}
