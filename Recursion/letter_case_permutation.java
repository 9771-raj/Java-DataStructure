package Recursion;
import java.util.*;
public class letter_case_permutation {
    static String str;
    static int n;
    public static void main(String[] args) {
        str="a1X";
        n=str.length();
        List<String> ans=new ArrayList<>();
        letterPermutation(0,ans,"");
        System.out.println(ans);
    }

    private static void letterPermutation(int index, List<String> ans, String store) {
        if (index==n){
            ans.add(store);
            return;
        }
        char ch=str.charAt(index);
        if (Character.isDigit(ch)){
            letterPermutation(index+1,ans,ch+store);
        }
        else{
            letterPermutation(index+1,ans,store+Character.toUpperCase(ch));
            letterPermutation(index+1,ans,store+Character.toLowerCase(ch));
        }

    }
}
