package LeetCode;
import java.util.*;
public class prime {
    public static void main(String[] args) {
        int ans=prime_factors(6);
        System.out.println(ans);
    }
    private static int prime_factors(int num){
        HashSet<Integer> hash=new HashSet<>();
        int n=num;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                hash.add(i);
                n /= i;
            }
        }
        return hash.size();
    }
}
