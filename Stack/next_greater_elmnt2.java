package Stack;
import java.util.*;
public class next_greater_elmnt2 {
    public static void main(String[] args) {
        int[] arr={1,29,3,4,3};
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        Stack<Integer> points=new Stack<>();
        for (int i=arr.length-2;i>=0;i--){
            points.push(arr[i]);
        }

        for (int i=arr.length-1;i>=0;i--){
            while(!points.isEmpty() && points.peek()<=arr[i]){
                points.pop();
            }
            ans[i]=points.isEmpty()?-1:points.peek();
        }
        st.push(arr[arr.length-1]);
        for (int i=arr.length-2;i>=0;i--){
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?ans[i]:st.peek();
            st.push(arr[i]);
        }
        int max=arr[0];
        int j=0;
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                j=i;
                max=arr[i];
            }
        }
        ans[j]=-1;



        System.out.println(Arrays.toString(ans));
    }
}
