package Doubt_solving;
import java.util.*;
public class haveSame_pattern {
    public static void main(String[] args) {
        String[] X={"leet", "abcd", "loot", "geek", "cool", "for", "peer", "dear", "seed", "meet","noon","otto","mess","loss"};
        String pat="moon";

        for (String str:X){
            HashMap<Character,Character> text=new HashMap<>();
            HashMap<Character,Character> pattern=new HashMap<>();

            if (pat.length()==str.length()){
                int i=0;
                for (i = 0; i < pat.length(); i++) {
                    char s=str.charAt(i);
                    char p=pat.charAt(i);
                    var prev=text.putIfAbsent(s,p);
                    if (prev!=null && text.get(s)!=p){
                        break;
                    }
                    prev=pattern.putIfAbsent(p,s);
                    if (prev!=null && pattern.get(p)!=s){
                        break;
                    }
                }

                if (i==pat.length()){
                    System.out.println(str);
                }
            }
        }
    }
}
