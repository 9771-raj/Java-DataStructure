package problems;
import java.util.*;          // Brute Force Approach
public class print_all_anagrams {
    public static void main(String[] args) {
        HashMap<Character,Integer> hash=new HashMap<>();
        String s="abcdbcafgacb";
        String p="abc";
        for(int i=0;i<p.length();i++){
            hash.put(p.charAt(i),hash.getOrDefault(p.charAt(i),0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int len=p.length();
        for(int i=0;i<s.length();i++){
            if((s.length()-i)<len){
                break;
            }
            String str=s.substring(i,len+i);
            //System.out.println(str);

            solution(str,i,ans,hash);
        }
        System.out.println(ans);
    }
    private static void solution(String s,int j,ArrayList<Integer> ans,HashMap<Character,Integer> hash){
        HashMap<Character,Integer> hash2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hash2.put(s.charAt(i),hash2.getOrDefault(s.charAt(i),0)+1);
        }
        if(hash.equals(hash2)){
            ans.add(j);
            System.out.println("hi");
        }
    }

}
