package DP;
import java.util.*;
public class triangle_minPathsum {
    static int[][] dp;
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            triangle.add(new ArrayList<>());
        }
        // insertion
        triangle.get(0).add(2);
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        //
        dp=new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.size(); j++) {
                dp[i][j]=-1;
            }
        }
        int ans=Triangle_minPathSum(triangle,0,0);
        System.out.println(ans);
    }

    private static int Triangle_minPathSum(List<List<Integer>> triangle,int r,int c) {
       if (r>= triangle.size()) return 0;
       return Math.min(Triangle_minPathSum(triangle,r+1,c),Triangle_minPathSum(triangle,r+1,c+1))+triangle.get(r).get(c);
    }

    private static int memoization(List<List<Integer>> triangle,int r,int c){
        if (r>= triangle.size()) return 0;
        if (dp[r][c]!=-1){
            return dp[r][c];
        }
        return dp[r][c]=Math.min(Triangle_minPathSum(triangle,r+1,c),Triangle_minPathSum(triangle,r+1,c+1))+triangle.get(r).get(c);

    }

}
