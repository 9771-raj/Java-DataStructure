package Recursion;
import java.util.*;
public class letter_comb_phonenumber {
    public static void main(String[] args) {
        HashMap<Character,String> hash=new HashMap<>();
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        ArrayList<String> ans=new ArrayList<>();
        solution(hash,"534",0,ans,"");
        System.out.println(ans);

    }

    private static void solution(HashMap<Character, String> hash, String s,int index,ArrayList<String> ans,String output) {
        // base case
        if (index>=s.length()){
            ans.add(output);
            return;
        }
        char ch=s.charAt(index);
        String str=hash.get(ch);
        for (int i = 0; i < str.length(); i++) {
            solution(hash,s,index+1,ans,output+str.charAt(i));

        }
    }


}
