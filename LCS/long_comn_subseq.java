package LCS;

public class long_comn_subseq {
        static int[][] memory;  // Global memory matrix
    public static void main(String[] args) {
        String a="abcs";
        String b="bcds";
        int ans=solution(a,b);
        System.out.println("Recursive Answer = "+ans);

        memory=new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                memory[i][j]=-1;
            }

        }
        int val=memorization(a,b,a.length(),b.length());
        System.out.println("Memorization Answer = "+val);

        int total=topDown(a,b,a.length(),b.length());
        System.out.println("Topdown Answer = "+total);

    }

    // Recursive approach
    private static int solution(String a, String b) {
        if(a.length()==0 || b.length()==0){
            return 0;
        }
        if(a.charAt(0)==b.charAt(0)){
            return 1+solution(a.substring(1),b.substring(1));
        }
        else{
            return Math.max(solution(a,b.substring(1)),solution(a.substring(1),b));
        }
    }

    //Memorization approach

    private static int memorization(String a, String b, int n, int m) {
        if(n==0 || m==0) return 0;
        if(memory[n-1][m-1]!=-1){
            return memory[n-1][m-1];
        }
        if(a.charAt(n-1)==b.charAt(m-1)){
            return memory[n-1][m-1]=1+memorization(a,b,n-1,m-1);
        }
        else{
            return memory[n-1][m-1]=Math.max(memorization(a,b,n-1,m),memorization(a,b,n,m-1));
        }
    }

    //Topdown Approach

    private static int topDown(String a, String b, int x, int m) {
        int n=x+1;
        int w=m+1;
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
        return dp[n-1][w-1];
    }

}
