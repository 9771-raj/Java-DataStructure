package LCS;
   // shortest common supersubsequence
public class shortest_comm_subseq {
    static String ans="";
    public static void main(String[] args) {
        String a="geek";
        String b="eke";
        String total=a+b;
        String lcs=LCS(a,b);
        //System.out.println(lcs);
        int len=total.length()-lcs.length();
        System.out.println("Length of shortest common supersequence = "+len);
    }

       private static String LCS(String a, String b) {
           int n=a.length()+1;
           int w=b.length()+1;
           int[][] dp=new int[n][w];
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < w; j++) {
                   if(i==0 || j==0){
                       dp[i][j]=0;
                   }
               }
           }
           for (int i = 1; i < n; i++) {
               for (int j = 1; j < w; j++) {
                   if(a.charAt(i-1)==b.charAt(j-1)){
                       dp[i][j]=1+dp[i-1][j-1];
                   }
                   else{
                       dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                   }
               }
           }
            int i=n-1;
           int j=w-1;
           while(i>0 && j>0){
               if(a.charAt(i-1)==b.charAt(j-1)){
                   ans+=a.charAt(i-1);
                   i--;
                   j--;
               }
               else{
                   if(dp[i-1][j]>dp[i][j-1]){
                       i--;
                   }else{
                       j--;
                   }
               }
           }
           String res="";
           for (int k = ans.length()-1; k>=0; k--) {
               res+=ans.charAt(k);
           }
           return res;
       }
   }
