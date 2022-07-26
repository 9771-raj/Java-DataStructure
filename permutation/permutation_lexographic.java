package permutation;
import java.util.*;
public class permutation_lexographic {
    static List<String > ans=new ArrayList<>();
    public static void main(String[] args) {
        String S="ABC";
        char[] arr=S.toCharArray();

        permute(0,arr);
        HashSet<String> set = new HashSet(ans);
        System.out.println(set);
        ans = new ArrayList<>(set);
        Collections.sort(ans);
        System.out.println(ans);
        System.out.println(ans);
    }
    public static void swap(int i,int j,char[] chr){
        char ch=chr[i];
        chr[i]=chr[j];
        chr[j]=ch;
    }
    public static void permute(int ind,char[] str){
        if(ind==str.length){
            String s="";

            for(int i=0;i<str.length;i++){
                s+=str[i];
            }
            ans.add(s);
            return;
        }
        for(int i=ind;i<str.length;i++){
            swap(ind,i,str);
            permute(ind+1,str);
            swap(ind,i,str);
        }
    }
}
