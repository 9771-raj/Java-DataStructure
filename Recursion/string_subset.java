package Recursion;
import java.util.*;
public class string_subset {
    public static void main(String[] args) {
        ArrayList<String> ans=new ArrayList<>();
        String str="abc";
        solution(str,ans,"");
        System.out.println(ans);
    }

    private static void solution(String str, ArrayList<String> ans, String out) {
        if (str.isEmpty()){
            //System.out.println(out);
            ans.add(out);
            return;
        }
        String op1=out;
        String op2=out;
        op2+=str.charAt(0);
        str=str.substring(1);
        solution(str,ans,op1);
        solution(str,ans,op2);

    }
}
