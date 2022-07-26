package DP;
import java.util.*;
public class climb_stairs {
    public static void main(String[] args) {
        int[] cost={10,15,20};

        int ans=Math.min(helper(cost.length-1,cost),helper(cost.length-2,cost));
        System.out.println(ans);
    }

    private static int helper(int length, int[] cost) {
        if (length==0 || length==1) return cost[length];
        int onestep=helper(length-1,cost);
        int twostep=helper(length-2,cost);
        return Math.min(onestep,twostep)+cost[length];
    }
}
