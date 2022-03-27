package LCS;

public class print_short_comm_superseq {
    public static void main(String[] args) {
        String a="heap";
        String b="eap";
        String sc_super=SCS(a,b);
        System.out.println(sc_super);
    }

    private static String SCS(String a, String b) {
        String scs="";
        int n=a.length()+1;
        int w=b.length()+1;
        int[][] dp=new int[n][w];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < w; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j < w; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=n-1;
        int j=w-1;
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                scs+=a.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    scs+=a.charAt(i-1);
                    i--;
                }
                else{
                    scs+=a.charAt(j-1);
                    j--;
                }
            }
        }
        while(i>0){
            scs+=a.charAt(i-1);
            i--;
        }
        while(j>0){
            scs+=a.charAt(j-1);
            j--;
        }
        String ans="";
        for (int k = scs.length()-1;k>=0;k--) {
            ans+=scs.charAt(k);
        }
        return ans;
    }
}
