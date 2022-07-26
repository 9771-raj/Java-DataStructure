package LeetCode;
import java.util.*;
public class odd_even {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};

        ArrayList<Integer> ans=new ArrayList<>();
        merge_odd_even(arr,ans);
        System.out.println(ans);
    }

    private static void merge_odd_even(int[] arr, ArrayList<Integer> ans) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0){
                even.add(arr[i]);
            }
            else{
                odd.add(arr[i]);
            }
        }
        ans.addAll(even);
        ans.addAll(odd);
    }
}
