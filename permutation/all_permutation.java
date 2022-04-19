package permutation;
import java.util.*;
public class all_permutation {
    public static void main(String[] args) {
        String str="abc";
        permutation(str,"");
        //findpermuataions("abcd");
    }


    //Recursive approach for printing all permutation
    public static void permutation(String str,String data){
        if(str.length()==0){
            System.out.println(data);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            String left_part=str.substring(0,i);
            String right_part=str.substring(i+1,str.length());
            String remain=left_part+right_part;
            permutation(remain,data+ch);
        }
    }

    //Another Recursive approach for printing all permutation
    private static void swap(char[] str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;

    }
    private static void findpermuataions(String str){
        if(str.isEmpty() || str.length()==0){
            return;
        }
        permute(str.toCharArray(),0);
    }

    private static void permute(char[] chars, int i) {
        if(i== chars.length-1){
            System.out.println(String.valueOf(chars));
        }

        for (int j = i; j < chars.length; j++) {
            swap(chars,i,j);
            permute(chars,i+1);
            swap(chars,i,j);
        }
    }
}
