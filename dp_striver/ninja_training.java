package dp_striver;

import java.util.Arrays;

public class ninja_training {
    static int[][] memory;
    static int max_price=0;
    public static void main(String[] args) {
        int[][] arr={ // 3 types of score in each day we have to find max score but if take type 0 then on next day you can't type 0 on next
                {1,2,30}, // day 0
                {40,5,6}, // day 1
                {7,8,9} // day 2
        };

        int ans_rec=ninja_training_recursion(arr,arr.length-1,3);
        System.out.println(ans_rec);

        // memoization
        memory=new int[arr.length][4];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(memory[i],-1);
        }

        int ans2=memoization(arr,arr.length-1,3);
        System.out.println(ans2);

        // bottom up
        int ans3=tabulation(arr);
        System.out.println(ans3);
    }

    private static int ninja_training_recursion(int[][] arr, int day,int prev) {
        if (day==0){
            int max=0;
            for (int i = 0; i < arr[0].length; i++) {
                max=Math.max(max,arr[day][i]);
            }
            return max;
        }
        int max=0;
        for (int i = 0; i < arr[0].length; i++) {
            if (i!=prev){
                int points=arr[day][i]+ninja_training_recursion(arr,day-1,i);
                max=Math.max(max,points);
            }
        }
        return max;

    }

    // memoization
    private static int memoization(int[][] arr,int day,int prev){
        if (day==0){
            int max=0;
            for (int i = 0; i < 3; i++) {
                max=Math.max(max,arr[day][i]);
            }
            return max;
        }
        if (memory[day][prev]!=-1){
            return memory[day][prev];
        }
        int max=0;
        for (int i = 0; i < 3; i++) {
            if (i!=prev){
                int points=arr[day][i]+memoization(arr,day-1,i);
                max=Math.max(max,points);
            }
        }
        return memory[day][prev]=max;
    }

    // tabulation
    private static int tabulation(int[][] arr){
        int[][] dp=new int[arr.length][4];
        dp[0][0]=Math.max(arr[0][2],arr[0][1]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
        dp[0][2]=Math.max(arr[0][0],arr[0][1]);
        dp[0][3]=Math.max(arr[0][1],Math.max(arr[0][1],arr[0][2]));

        for (int day = 1; day < arr.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last]=0;
                for (int i = 0; i < 3; i++) {
                    if (i!=last){
                        int points=arr[day][i]+dp[day-1][i];
                        dp[day][last]=Math.max(dp[day][last],points);
                    }
                }

            }
        }
        return dp[arr.length-1][3];
    }
}
