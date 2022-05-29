package Stack;
import java.util.*;

//For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
//then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
// main approach min from left most corner ans=(element_index - min_index)
//
public class stockSpan_problem {
    public static void main(String[] args) {
        int[] arr={100, 80, 60, 70, 60, 75, 85};
        int[] ans=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        ans[0]=1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?(i+1):(Math.abs(i-stack.peek()));
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
