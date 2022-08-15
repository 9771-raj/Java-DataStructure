package Doubt_solving;
import java.util.*;
public class count_occurence_anagram {
    public static void main(String[] args) {
        String pat="for";
        String txt="forabdorfbgdrof";
        int n=pat.length();
        int m=txt.length();

        HashMap<Character,Integer> hash_pat=new HashMap<>();
        for(int i=0;i<n;i++){
            hash_pat.put(pat.charAt(i),hash_pat.getOrDefault(pat.charAt(i),0)+1);
        }

        HashMap<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            hash.put(txt.charAt(i),hash.getOrDefault(txt.charAt(i),0)+1);
        }
        int count=0;
        if(hash.equals(hash_pat)){
            count++;
        }
        for(int i=n;i<m;i++){
            char ch=txt.charAt(i);
            hash.put(txt.charAt(i),hash.getOrDefault(txt.charAt(i),0)+1);
            int d=i-n;
            char de_=txt.charAt(d);
            int z=hash.get(de_);
            z-=1;
            if(z==0){
                hash.remove(de_);
            }
            else{
                hash.put(de_,z);
            }

            //System.out.println(hash+" "+hash_pat+"    "+count);
            if(hash.equals(hash_pat)){
                count++;
            }
        }
        System.out.println(count);


    }
}
