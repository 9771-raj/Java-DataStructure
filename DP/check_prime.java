package DP;
import java.util.*;
public class check_prime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int ans=solution(num);
        System.out.println(ans);
    }

    private static int solution(int num) {
        boolean is_prime=checkPrime(num);
        int flag=0;
        if (is_prime==false) return 0;
        flag=1;
        boolean contain_3=contain3(num);
        if (contain_3==false) return 0;
        return flag;

    }

    private static boolean contain3(int num) {
        if (num==3) return true;
        int data=num;
        while (data!=0){
            int rem=data%10;
            if (rem==3) return true;
            data=data/10;
        }
        return false;
    }

    private static boolean checkPrime(int num) {
        if (num<=1) return false;
        else if (num==2) return true;
        else if (num%2==0) return false;
        for (int i = 3; i < Math.sqrt(num); i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
