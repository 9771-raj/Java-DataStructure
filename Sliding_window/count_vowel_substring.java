package Sliding_window;
import java.util.*;
public class count_vowel_substring {
    public static void main(String[] args) {
        String str = "cuaieuouac";
        //HashMap<Character,Integer> hash=new HashMap<>();
        String vowel ="aeiou";
        int count=0;
        for (int i = 0; i <str.length() ; i++) {
            HashMap<Character,Integer>map=new HashMap<>();
            for(int j=i;j<str.length();j++){
                if(!vowel.contains(str.charAt(j)+"")){
                    break;
                }
                map.put(str.charAt(j),1);
                if(map.size()==5){
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
