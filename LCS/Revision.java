package LCS;
import java.util.*;
public class Revision {
    static int[][] memory;
    public static void main(String[] args) {
        String a="abcderh";
        String b="abdfgerh";

//        int ans=long_common_sub(a,b);
//        System.out.println(ans);
//        memory=new int[a.length()][b.length()];
//        for (int i = 0; i < a.length(); i++) {
//            for (int j = 0; j < b.length(); j++) {
//                memory[i][j]=-1;
//            }
//        }
//        int ans2=LCS_memo(a,b,a.length(),b.length());
//        System.out.println(ans2);

//        int ans3=LCS_tabulation(a,b,a.length(),b.length());
//        System.out.println(ans3);

        // Longest Common Substring
        int ans4=LCSubstring(a,b,a.length(),b.length());
        System.out.println(ans4);
    }

    private static int LCSubstring(String a, String b, int m, int n) {
        int x=m+1;
        int w=n+1;
        int[][] dp=new int[x][w];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <w; j++) {
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < w; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        int max=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < w; j++) {
                if (dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }

    private static int LCS_tabulation(String a, String b, int m, int n) {
        int x=m+1;
        int w=n+1;
        int[][] dp=new int[x][w];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <w; j++) {
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 1; i <x; i++) {
            for (int j = 1; j <w; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[x-1][w-1];
    }

    private static int LCS_memo(String a, String b,int n,int m) {
       if (n==0 || m==0) return 0;
       if (memory[n-1][m-1]!=-1){
           return memory[n-1][m-1];
       }
       if (a.charAt(n-1)==b.charAt(m-1)){
           return memory[n-1][m-1]=1+LCS_memo(a,b,n-1,m-1);
       }
       else{
           return memory[n-1][m-1]=Math.max((LCS_memo(a,b,n-1,m)),LCS_memo(a,b,n,m-1));
       }
    }

    private static int long_common_sub(String a, String b) {
        if (a.length()==0 || b.length()==0){
            return 0;
        }
        if (a.charAt(0)==b.charAt(0)){
            return 1+long_common_sub(a.substring(1),b.substring(1));
        }
        else{
            return Math.max(long_common_sub(a.substring(1),b),long_common_sub(a,b.substring(1)));
        }
    }


}
