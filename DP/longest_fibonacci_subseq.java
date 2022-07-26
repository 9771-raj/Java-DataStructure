package DP;
import java.util.*;
public class longest_fibonacci_subseq {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        ArrayList<Integer> list1=new ArrayList<Integer>();
        int max_len=solve(arr);
        System.out.println(max_len);

    }

    private static int solve(int[] A) {
        Set<Integer> s=new HashSet<Integer>();
        for(int i : A){
            s.add(i);
        }
        int res=0;
        int n=A.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int a=A[i];
                int b=A[j];
                int c=a+b;
                int count=2;
                while(s.contains(c)){
                    count++;
                    res=Math.max(res,count);
                    a=b;
                    b=c;
                    c=a+b;
                }
            }
        }
        if(res>2){
            return res;
        }else{
            return 0;
        }

    }
}
