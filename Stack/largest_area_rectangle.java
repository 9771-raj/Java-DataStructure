package Stack;
import java.util.*;
public class largest_area_rectangle {
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        Stack<Integer> st_left=new Stack<>();
        st_left.push(0);
        left[0]=0;
        for (int i=1;i<arr.length;i++){
            while (!st_left.isEmpty() && arr[i]<=arr[st_left.peek()]){
                st_left.pop();
            }
            left[i]=st_left.isEmpty()?0:st_left.peek()+1;
            st_left.push(i);
        }
        System.out.println(Arrays.toString(left));

        Stack<Integer> st_right=new Stack<>();
        st_right.push(arr.length-1);
        right[arr.length-1]=arr.length-1;
        for (int i=arr.length-2;i>=0;i--){
            while (!st_right.isEmpty() && arr[i]<=arr[st_right.peek()]){
                st_right.pop();
            }
            right[i]=st_right.isEmpty()?arr.length-1:st_right.peek()-1;
            st_right.push(i);
        }
        System.out.println(Arrays.toString(right));

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,((right[i]-left[i]+1)*arr[i]));
        }
        System.out.println(max);

    }
}
