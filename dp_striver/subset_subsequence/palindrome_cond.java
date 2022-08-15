package dp_striver.subset_subsequence;
import java.util.*;
public class palindrome_cond {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int totalSize=0;
        int count=0;
        for (int i = 0; i < str.length()-2; i++) {
            String s=str.substring(i);
            if(s.length()>=3 && isCondition_pass(str.substring(i))){
                count++;
                totalSize+=s.length();
            }
        }
        System.out.println("Total Size: "+totalSize);
        System.out.println("Total Count: "+count);
    }

    private static boolean isCondition_pass(String str) {
        boolean palindrome_check=isPalindrome(str);
        boolean check_vowel=isVowel(str);
        return palindrome_check && check_vowel;
    }

    private static boolean isVowel(String str) {
        for (int i = 0; i <str.length(); i++) {
            char ch=str.charAt(i);
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o'|| ch=='u'|| ch=='A' || ch=='E' || ch=='I' || ch=='O'|| ch=='U'){
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(String str) {
        int i=0;
        int j=str.length()-1;
        while (i<=j ){
            if (str.charAt(i)==str.charAt(j)){
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
