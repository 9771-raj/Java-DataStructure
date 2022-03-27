package MCM;

public class palindrome_partition {
    public static void main(String[] args) {
        String str="abcgeffebad";
        int ans=solve(str,0,str.length()-1);
        System.out.println(ans);
    }

    private static int solve(String str, int i, int j) {
        int min=Integer.MAX_VALUE;
        if(i>=j) return 0;
        if(isPalindrome(str,i,j)==true) return 0;
        for (int k = i; k <j; k++) {
            int temp=solve(str,i,k)+solve(str,k+1,j)+1;
            if(temp<min){
                min=temp;
            }
        }
        return min;
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
