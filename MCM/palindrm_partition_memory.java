package MCM;

public class palindrm_partition_memory {
    static int[][] memory;
    public static void main(String[] args) {
        String s="eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        memory=new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                memory[i][j]=-1;
            }
        }
        int ans=solve(s,0,s.length()-1);
        System.out.println(ans);
    }

    private static int solve(String s, int i, int j) {
        if(i>=j) return 0;
        if(memory[i][j]!=-1) return memory[i][j];
        if(isPalindrome(s,i,j)==true) return 0;
        int min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp=solve(s,i,k)+solve(s,k+1,j)+1;
            if(temp<min){
                min=temp;
            }
        }
        return memory[i][j]=min;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
