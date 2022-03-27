package Recursion;

public class total_subset_continugous {
    public static void main(String[] args) {
        solution("","abc");
    }

    private static void solution(String np, String p) {
        if(p.length()==0){
            System.out.println(np);
            return;
        }
        char ch=p.charAt(0);
        solution(np+ch,p.substring(1));
        solution(np,p.substring(1));
    }

}
