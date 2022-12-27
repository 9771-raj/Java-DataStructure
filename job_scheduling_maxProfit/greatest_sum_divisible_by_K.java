package job_scheduling_maxProfit;
import java.util.Arrays;
public class greatest_sum_divisible_by_K {
    public static void main(String[] args) {
        int[] arr={3,6,5,1,8};
        int[] dp=new int[3];
        Arrays.fill(dp,0);
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i];
            int[] dp_=Arrays.copyOf(dp,3);
            for (int j = 0; j < 3; j++) {
                int data=dp[j];
                int sum=temp+data;
                int rem=sum%3;
                dp_[rem]=Math.max(dp_[rem],sum);
                System.out.println(Arrays.toString(dp_)+" "+Arrays.toString(dp));
            }
            dp=Arrays.copyOf(dp_,3);
        }
        System.out.println(Arrays.toString(dp));
    }
}
