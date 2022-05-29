package Recursion;

public class permutation_caseChange {
    public static void main(String[] args) {
        String str="aB";
        solution(str,"");
    }

    private static void solution(String str, String output) {
        if (str.isEmpty()){
            System.out.println(output);
            return;
        }
        char ch=str.charAt(0);
        String op1=output;
        String op2=output;
        solution(str.substring(1),output+Character.toLowerCase(ch));
        solution(str.substring(1),output+Character.toUpperCase(ch));
    }
}
