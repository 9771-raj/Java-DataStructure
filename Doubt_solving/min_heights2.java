package Doubt_solving;
import java.util.*;
public class min_heights2 {
    public static void main(String[] args) {
        int[] arr={1,5,8,10};
        int k=2;
        int[] visited=new int[arr.length];
        int ans=f(arr,k,arr.length);
        System.out.println(ans);

    }
    private static int f(int[] arr,int k,int n){

        Arrays.sort(arr);
        // Maximum possible height difference
        int ans = arr[n - 1] - arr[0];

        int tempmin, tempmax;
        tempmin = arr[0];
        tempmax = arr[n - 1];

        for (int i = 1; i < n; i++) {

            // if on subtracting k we got negative then
            // continue
            if (arr[i] - k < 0)
                continue;

            // Minimum element when we add k to whole array
            tempmin = Math.min(arr[0] + k, arr[i] - k);

            // Maximum element when we subtract k from whole
            // array
            tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            ans = Math.min(ans, tempmax - tempmin);
        }
        return ans;
    }
}
