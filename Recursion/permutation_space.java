package Recursion;
import java.util.*;
public class permutation_space {
    public static void main(String[] args) {
        String str="ABC";

        Permutation_space(0,str.length(),str,"");
    }

    private static void Permutation_space(int index,int n,String str, String s) {
        if (str.isEmpty()){
            System.out.println(s);
            return;
        }
        if (index==0){
            char ch=str.charAt(0);
            Permutation_space(index+1,n,str.substring(1),s+ch);
        }
        else{
            char ch=str.charAt(0);
           Permutation_space(index+1,n,str.substring(1),s+ch);
           Permutation_space(index+1,n,str.substring(1),s+"_"+ch);
        }

    }
}
