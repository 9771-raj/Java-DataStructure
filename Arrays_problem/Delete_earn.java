package Arrays_problem;
import java.util.*;
public class Delete_earn {
    public static void main(String[] args) {
        int[] arr={3,3,4,2};
        int[] freq=new int[10002];
        int[] dp=new int[10002];
        freq[0]=1;
        freq[1]=1*freq[1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+i*freq[i]);
        }
        System.out.println(dp[10001]);

    }
}
