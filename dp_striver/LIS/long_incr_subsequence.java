package dp_striver.LIS;
import java.util.Arrays;
public class long_incr_subsequence {
    static int[][] mem;
    public static void main(String[] args) {
        int[] arr={10,3,4,5,1,2,9,11};   // 3,4,5,9,11
        int ans=rec_LIS(0,-1,arr);
        System.out.println(ans);

        // memoization
        mem=new int[arr.length][arr.length+1];
        for (int i=0;i<arr.length;i++){
            Arrays.fill(mem[i],-1);
        }
        int ans2=memory_lis(0,-1,arr);
        System.out.println(ans2);

        //tabulation
        int ans3=tabulation_lis(arr);
        System.out.println(ans3);

        //
        int ans4=tabulation_NEW(arr);
        System.out.println(ans4);
    }

    private static int rec_LIS(int i, int prev_index, int[] arr) {
        // base case
        if (i==arr.length){
            return 0;
        }

        int len=rec_LIS(i+1,prev_index,arr); // not take
        if (prev_index==-1 || arr[i]>arr[prev_index]){
            len=Math.max(len,1+rec_LIS(i+1,i,arr));  // take
        }
        return len;
    }

    private static int memory_lis(int i,int prev_index,int[] arr){
        // base case
        if (i==arr.length){
            return 0;
        }
        if (mem[i][prev_index+1]!=-1){
            return mem[i][prev_index+1];
        }
        int len=memory_lis(i+1,prev_index,arr); // not take
        if (prev_index==-1 || arr[i]>arr[prev_index]){
            len=Math.max(len,1+memory_lis(i+1,i,arr));  // take
        }
        return mem[i][prev_index+1]=len;
    }

    private static int tabulation_lis(int[] arr){
        int[][] dp=new int[arr.length+1][arr.length+1];
        int n=arr.length;
        for (int i = n-1;i>=0; i--) {
            for (int prev_index=i-1;prev_index>=-1;prev_index--){
                int len=dp[i+1][prev_index+1]; // not take
                if (prev_index==-1 || arr[i]>arr[prev_index]){
                    len=Math.max(len,1+dp[i+1][i+1]);  // take
                }
                dp[i][prev_index+1]=len;
            }
        }
        return dp[0][-1+1];
    }

    // new mode of tabulation      // this solution required if you want to trace back the lis or print the lis
    private static int tabulation_NEW(int[] arr){
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        int maxi=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }

}
