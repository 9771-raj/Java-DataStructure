package Doubt_solving;
import java.util.*;
public class IsomorphicStrings {
    public static void main(String[] args) {
        String X="ACAB";
        String Y="XCXY";
        boolean ans=isIsomorphic(X,Y);
        System.out.println(ans);
    }
    public static boolean isIsomorphic(String X, String Y)
    {
        if(X==null || Y==null) return false;
        if(X.length()!=Y.length()) return false;

        HashMap<Character,Character> hash=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for (int i=0;i<X.length();i++){
            char ch1=X.charAt(i);
            char ch2=Y.charAt(i);
            if(hash.containsKey(ch1)){
                if(hash.get(ch1)!=ch2){
                    return false;
                }
            }
            else{
                if(set.contains(ch2)){
                    return false;
                }
                hash.put(ch1,ch2);
                set.add(ch2);
            }
        }
        return true;
    }
}
