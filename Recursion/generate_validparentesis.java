package Recursion;
import java.util.*;
public class generate_validparentesis {
    public static void main(String[] args) {
        int n=3;
        ArrayList<String> ans=new ArrayList<>();
        solution(n,n,ans,"");
        System.out.println(ans);
    }

    private static void solution(int n,int m, ArrayList<String> ans, String output) {
        if (n==0 && m==0){
            ans.add(output);
            return;
        }

        if (n!=0){
            solution(n-1,m,ans,output+"(");
        }
        if (m>n){
            solution(n,m-1,ans,output+")");
        }
    }
}
