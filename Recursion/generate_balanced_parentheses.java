package Recursion;
import java.util.*;
public class generate_balanced_parentheses {
    public static void main(String[] args) {
        int n=3;
        int m=3;
        List<String> ans=new ArrayList<>();

        Balanced_parenthesis(n,m,"",ans);
        System.out.println(ans);

    }

    private static void Balanced_parenthesis(int open, int close, String str, List<String> ans) {
        if (open==0 && close==0){
            ans.add(str);
            return;
        }
        if (open!=0){
            String op1=str;
            op1=op1+"(";
            Balanced_parenthesis(open-1,close,op1,ans);
        }
        if (close>open){
            String op2=str;
            op2=op2+")";
            Balanced_parenthesis(open,close-1,op2,ans);
        }

    }
}
