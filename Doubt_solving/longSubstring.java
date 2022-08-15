package Doubt_solving;
import java.util.*;
public class longSubstring {
    public static void main(String[] args) {
        String str="okmnijnhbtgv";
        findLongestSubstring(str);

    }
    public static void findLongestSubstring(String s)
    {
        String ans="";
        int max=Integer.MIN_VALUE;
        HashMap<String,Integer> hash_=new HashMap<>();
        HashMap<Character,Integer> hash=new HashMap<>();
        int i=0;
        int len=s.length();
        while(i<len){

            char ch=s.charAt(i);
            if(hash.containsKey(ch)){
                hash_.put(ans,ans.length());
                i=hash.get(ch)+1;
                hash.clear();
                ans="";
                continue;
            }
            ans+=ch;
            hash.putIfAbsent(ch,i);
            i++;
        }
        System.out.println(hash_);   // by iterating hash we can get max length and print that string
    }
}
