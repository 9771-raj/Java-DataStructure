package Arrays_problem;
import java.util.*;
public class string_split {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(str);
        int ans=total_words(str);
        System.out.println(ans);
    }

    private static int total_words(String str) {
        String[] arr=str.split(" ");
        return arr.length;
    }
}
