package Recursion;
import java.util.*;
public class josephus_problem {
    public static void main(String[] args) {
        int n=10;
        int k=4;
         int ans=solve(n,k);
        System.out.println(ans);
    }

    private static int solve(int n, int k) {
        if (n==1){
            return 0;
        }
        int softmat=solve(n-1,k);
        int y=(n+k)%n;
        return y;
    }
}
