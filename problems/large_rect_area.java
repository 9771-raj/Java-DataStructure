package problems;
import java.util.*;
public class large_rect_area {
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        int[] index=new int[arr.length];
        right_largest_index(arr,index);
        int[] index_left=new int[arr.length];
        left_largest_index(arr,index_left);
        System.out.println(Arrays.toString(index));
        System.out.println(Arrays.toString(index_left));
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,(index[i]-index_left[i]+1)*arr[i]);
        }
        System.out.println(max);
    }

    private static void left_largest_index(int[] arr, int[] index_left) {
        Stack<Integer> stack=new Stack<>();
        index_left[0]=0;
        stack.push(0);
        for (int i=1;i<arr.length;i++){
            while (stack.size()!=0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            index_left[i]=stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }
    }

    private static void right_largest_index(int[] arr, int[] index) {
        Stack<Integer> stack=new Stack<>();
        index[arr.length-1]= arr.length-1;
        stack.push(arr.length-1);
        for (int i = arr.length-2;i>=0; i--) {
            while (stack.size()!=0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            index[i]=stack.isEmpty()?arr.length-1:stack.peek()-1;
            stack.push(i);
        }
    }
}
