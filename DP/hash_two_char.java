package DP;


import java.util.*;
public class hash_two_char {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        //System.out.println(str);
        int ans=solution(str);
        System.out.println(ans);


    }
    private static int solution(String str){
        if (str.length()==1){
            return 1;
        }
        if (str.length()==0) return 0;
        HashMap<Character,Integer> hash=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hash.put(str.charAt(i),hash.getOrDefault(str.charAt(i),0)+1);
        }
        int count=0;
        for (Character ch:hash.keySet()){
            if (hash.get(ch)==1){
                count++;
            }
        }
        return count;
    }
}
