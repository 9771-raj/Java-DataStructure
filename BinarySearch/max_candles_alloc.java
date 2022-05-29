package BinarySearch;
import java.util.*;
public class max_candles_alloc {
    public static void main(String[] args) {
        int[] candy={5,8,6};
        int k=4;
        Arrays.sort(candy);
        int ans=max_candies(candy,k);
        System.out.println(ans);

    }

    private static int max_candies(int[] candy, int k) {
        long sum=0;
        for (int i = 0; i < candy.length; i++) {
            sum+=candy[i];
        }
        if (sum<k){
            return 0;
        }
        if (sum==k){
            return 1;
        }
        long ans=sum/k;
        if (ans==1) return (int)ans;
        long low=0;
        long high=ans;
        while (low<=high){
            long mid=low+(high-low)/2;
            long c=0;
            for (int i = 0; i < candy.length; i++) {
                c+=(long)candy[i]/mid;
            }
            if(c>=k){
                ans=mid;
                // System.out.println(ans);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)ans;
    }
}
