package LCS;
import java.util.ArrayList;
public class seq_pattern_match {
    // Using Recursion
    static ArrayList<String> arr=new ArrayList<>();
    public static void main(String[] args) {
        String a="axy";
        String b="adxcpy";
        solution(a,b,"");
        System.out.println(arr.contains(a));
    }

    private static void solution(String a, String b,String str) {
        if(a.length()==0 || b.length()==0){
            arr.add(str);
            return;
        }
        if(a.charAt(0)==b.charAt(0)){
            solution(a.substring(1),b.substring(1),str+a.charAt(0));
        }
        solution(a.substring(1),b,str);
        solution(a,b.substring(1),str);
    }
}
