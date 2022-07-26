package Recursion;
import java.util.*;
public class subsequence {
    public static void main(String[] args) {
        String str="abc";
        Subsequence(str,"");
        int[] arr={1,3,2};
        print_sequence(arr,0,new ArrayList<Integer>());
    }

    private static void print_sequence(int[] arr, int i, ArrayList<Integer> ans) {
        if (i>=arr.length){
            System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        print_sequence(arr,i+1,ans);
        ans.remove(ans.size()-1);
        print_sequence(arr,i+1,ans);
    }

    private static void Subsequence( String str, String s) {
        if (str.isEmpty()){
            System.out.println(s);
            return;
        }
        char ch=str.charAt(0);
        Subsequence(str.substring(1),s+ch);
        Subsequence(str.substring(1),s);
    }

}
