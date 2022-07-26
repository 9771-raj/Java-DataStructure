package Stack;
import java.util.*;
public class max_area_hist {
    public static void main(String[] args) {

        String s="agag";
        char[] a=new char[s.length()];
        a=s.toCharArray();
        System.out.println(a[0]);

        long[] hist={6,2,5,4,5,1,6};
        int n= hist.length;;
        int size =  hist.length;
        long[] nsl =  left_side_min(hist,size);
        long[] nsr =  right_side_min(hist,size);

        long[] height = new long[size];

        for(int i=0;i<n;i++){
            height[i] = nsr[i] - nsl[i] -1;
        }

        long MaxHeight = 0;
        for(int i=0;i<n;i++){
            long c = hist[i]*height[i];
            if(MaxHeight<c){
                MaxHeight = c;
            }
        }
        System.out.println(MaxHeight);

    }
    private static long[] left_side_min(long[] hist,int n){
        int[] left=new int[n];
        long[] index = new long[n];
        //left[0]=-1;
        Stack<Integer> st=new Stack<>();
        //st.push(0);
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                left[i] = -1;
            }else if(hist[st.peek()]>=hist[i]){
                while(!st.isEmpty() && hist[i]<=hist[st.peek()]){
                    st.pop();
                }
                left[i]=st.isEmpty() ? -1:st.peek();
            }else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            index[i]=left[i];
        }
        return index;

    }
    private static long[] right_side_min(long[] hist,int n){
        int[] right=new int[n];
        long[] index = new long[n];
        //right[n-1]=n-1;
        Stack<Integer> st=new Stack<>();
        //st.push(n-1);
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                right[i] = n;
            }else if(hist[st.peek()]>=hist[i]){
                while(!st.isEmpty() && hist[i]<=hist[st.peek()]){
                    st.pop();
                }
                right[i]=st.isEmpty() ? n:st.peek();
            }else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            index[i]=right[i];
        }
        return index;
    }
}
