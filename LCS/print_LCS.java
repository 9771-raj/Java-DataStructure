package LCS;

public class print_LCS {
    public static void main(String[] args) {
        //solution("abcdaf","acbcf","");
        String a="abcdaf";
        String b="acbcf";
        String result=print_lcs_topdown(a,b,a.length()+1,b.length()+1);
        System.out.println(" For accurate answer reverse the answer = "+result);
    }

    // Recursive approach

    public static void solution(String a,String b,String ans){
        if(a.length()==0 || b.length()==0){
            System.out.print(ans+" ");
            return;
        }
        if(a.charAt(0)==b.charAt(0)){
            solution(a.substring(1),b.substring(1),a.charAt(0)+ans);
        }
        solution(a.substring(1),b,ans);
        solution(a,b.substring(1),ans);
    }

    //Topdown Approach
    public static String print_lcs_topdown(String a,String b,int n,int w){
        String ans="";
        int[][] dp=new int[n][w];
        //initialize using base condition of recursive part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        // choice diagram code
        // memorise how to change recursion choice diagram in topdown matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        // code for logic of print lcs
        int i=n-1;
        int j=w-1;
        while (i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                ans+=a.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
        return ans;
    }

}
