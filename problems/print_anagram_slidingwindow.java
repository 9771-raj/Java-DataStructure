package problems;
import java.util.*;
public class print_anagram_slidingwindow {
    public static void main(String[] args) {
        HashMap<Character,Integer> hash=new HashMap<>();
        String s="abcdbcafgacb";
        String p="abc";
        for(int i=0;i<p.length();i++){
            hash.put(p.charAt(i),hash.getOrDefault(p.charAt(i),0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int len=p.length();
        HashMap<Character,Integer> data=new HashMap<>();
        for (int i = 0; i < len; i++) {
            data.put(s.charAt(i),data.getOrDefault(s.charAt(i),0)+1);
        }
        int k=0;
        int j=len;
        while (j<s.length()){
            if(hash.equals(data)){
                ans.add(k);
            }
            char ch=s.charAt(j);
            data.put(ch,data.getOrDefault(ch,0)+1);
            char chr=s.charAt(j-p.length());
            if(data.get(chr)==1){
                data.remove(chr);
            }else {
                data.put(chr,data.get(chr)-1);
            }
            k++;
            j++;
        }
        if(hash.equals(data)){
            ans.add(k);
        }

        System.out.println(ans);
    }
}
