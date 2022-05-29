package Stack;
//https://www.geeksforgeeks.org/find-maximum-difference-between-nearest-left-and-right-smaller-elements/?ref=lbp
import java.util.*;
public class max_difference {
    public static void main(String[] args) {
        int[] arr={2, 4, 8, 7, 7, 9, 3};

        // right side small from an element from array
        int[] right_small=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(arr[arr.length-1]);
        right_small[arr.length-1]=0;
        for (int i=arr.length-2;i>=0;i--){
            while (!stack.isEmpty() && arr[i]<=stack.peek()){
                stack.pop();
            }
            right_small[i]=stack.isEmpty()?0:stack.peek();
            stack.push(arr[i]);
        }
        System.out.println("RS - "+Arrays.toString(right_small));

        // left side small from an element from array
        int[] left_small=new int[arr.length];
        Stack<Integer> stack2=new Stack<>();
        stack2.push(arr[0]);
        left_small[0]=0;
        for (int i=1;i<arr.length;i++){
            while (!stack2.isEmpty() && arr[i]<=stack2.peek()){
                stack2.pop();
            }
            left_small[i]=stack2.isEmpty()?0:stack2.peek();
            stack2.push(arr[i]);
        }
        System.out.println("LS - "+Arrays.toString(left_small));

        int max=0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,(Math.abs(left_small[i]-right_small[i])));
        }
        System.out.println("Max Difference = "+max);

    }
}
