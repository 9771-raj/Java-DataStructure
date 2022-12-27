package Sliding_window;
import java.util.*;
public class minimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        HashMap<Character,Integer> req=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            req.put(t.charAt(i),req.getOrDefault(t.charAt(i),0)+1);
        }

        int min=Integer.MAX_VALUE;
        String result="";

        int m=s.length();
        int count=req.size();
        int right=0;
        int left=0;
        while (right<m){
            char ch=s.charAt(right);
            if (req.containsKey(ch)){
                req.put(ch,req.get(ch)-1);
                if (req.get(ch)==0)
                    count--;
            }

            if (count>0){
                right++;
            }
            else if (count==0){
                while (count==0){
                    if (right-left+1<min){
                        min=right-left+1;
                        result=s.substring(left,right+1);
                    }
                    char gen=s.charAt(left);
                    if (req.containsKey(gen)){
                        req.put(gen,req.get(gen)+1);
                        if (req.get(gen)==1)
                            count++;
                    }
                    left++;
                }
                right++;
            }
        }
        System.out.println(result);
    }
}
