package Stack;
import java.util.*;
public class rev_word_string {
    public static void main(String[] args) {
        String S="i.like.this.program.very.much";

        Stack<Character> st=new Stack<>();
        String ans="";
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='.'){
                st.push(S.charAt(i));
            }
            else{
                while(!st.isEmpty()){
                    ans+=st.pop();
                }
                ans+=".";
            }
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        System.out.println(ans);
    }
    static String reverse(String str){
        String ans="";
        char[] a=new char[str.length()];
        a=str.toCharArray();
        int i=0;
        int j=str.length()-1;
        while(i<j){
            char t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
        for(int k=0;k<str.length();k++){
            ans+=a[k];
        }
        return ans;
    }
}
