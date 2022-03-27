package DP;

public class rob_house_notadjacent {
    public static void main(String[] args) {
        int[] nums={2,3,4,8,6,4,9,8};
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        if(nums.length==1){
            System.out.println(nums[0]);
        }
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        System.out.println(dp[nums.length-1]);
    }
}
