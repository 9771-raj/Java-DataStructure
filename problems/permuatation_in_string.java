package problems;
import java.util.*;
//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//        In other words, return true if one of s1's permutations is the substring of s2.
public class permuatation_in_string {
    public static void main(String[] args) {
        String s1="adc";
        String s2="dcda";
        HashMap<Character,Integer> hash1=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hash1.put(s1.charAt(i),hash1.getOrDefault(s1.charAt(i),0)+1);
        }

        boolean ans=find_permute(s2,s1,hash1);
        System.out.println(ans);
    }

    private static boolean find_permute(String s2,String s1, HashMap<Character, Integer> hash1) {
        HashMap<Character,Integer> hash2=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hash2.put(s2.charAt(i),hash2.getOrDefault(s2.charAt(i),0)+1);
        }
        int j=0;
        if(hash1.equals(hash2)) return true;
        int len=s2.length()-s1.length();
        for (int i = s1.length(); i < s2.length(); i++) {

            char ch=s2.charAt(j);
            if(hash2.get(ch)==1){
                hash2.remove(ch);
            }
            else{
                hash2.put(ch,hash2.get(ch)-1);
            }
            hash2.put(s2.charAt(i),hash2.getOrDefault(s2.charAt(i),0)+1);
            if(hash1.equals(hash2)){
                return true;
            }
            j++;

        }

        return false;
    }
}
