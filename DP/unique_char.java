package DP;
import java.util.*;
public class unique_char {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int ans=solution(str);
        System.out.println(ans);
    }

    private static int solution(String str) {
        if (str.length()==1) return 1;
        if (str.length()==0) return 0;
        HashSet<Character> hash=new HashSet<>();
        for (int i=0;i<str.length();i++){
            hash.add(str.charAt(i));
        }
        return hash.size();
    }
}
