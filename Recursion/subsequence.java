package Recursion;

public class subsequence {
    public static void main(String[] args) {
        String str="abc";
        Subsequence(str,"");
    }

    private static void Subsequence( String str, String s) {
        if (str.isEmpty()){
            System.out.println(s);
            return;
        }
        char ch=str.charAt(0);
        Subsequence(str.substring(1),s+ch);
        Subsequence(str.substring(1),s);
    }
}
