package Recursion;
import java.util.*;           // print all subsets sum  duplicates allowed
/*
                N = 2
                arr[] = {2, 3}
                Output:
                0 2 3 5
*/
public class all_subsets_sum {
    static ArrayList<Integer> ans=new ArrayList<>();
    public static void main(String[] args) {
        int n=2;
        int[] arr={2,3};
        all_subsets_Sum(arr,n,0,0,ans);
        System.out.println(ans);
    }

    private static void all_subsets_Sum(int[] arr, int n, int ind, int sum, ArrayList<Integer> ans) {
        if (ind==n){
            ans.add(sum);
            return;
        }
        all_subsets_Sum(arr,n,ind+1,sum+arr[ind],ans);
        System.out.println(sum);
        all_subsets_Sum(arr,n,ind+1,sum,ans);

    }
}
