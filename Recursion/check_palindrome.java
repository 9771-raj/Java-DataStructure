package Recursion;

public class check_palindrome {
    public static void main(String[] args) {
        String str="maddame";
        boolean ans=checkPalindrome(str,0,str.length()-1);
        System.out.println(ans);
    }

    private static boolean checkPalindrome(String str, int i, int j) {
        if (i>=j) return true;
        return (str.charAt(i)==str.charAt(j)) && checkPalindrome(str,i+1,j-1);
    }
}
