package LeetCode;
import java.util.*;
public class group_anagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        if (strs==null || strs.length==0){
            System.out.println("Empty array of string given!");
        }
        HashMap<String,ArrayList<String>> hash=new HashMap<>();
        for (String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String st=String.valueOf(ch);
            if (hash.containsKey(st)){
                hash.get(st).add(s);
            }
            else{
                ArrayList<String> arr=new ArrayList<>();
                arr.add(s);
                hash.put(st,arr);
            }
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for (Map.Entry<String,ArrayList<String>> mp:hash.entrySet()){
            ans.add(new ArrayList<>(mp.getValue()));
        }
        System.out.println(ans);
    }
}
