package Recursion;
import java.util.*;
public class all_subsets_without_duplicate {
    public static void main(String[] args) {
        int n=4;
        int[] arr={1,2,2,3};
        solution(arr,n,0,new ArrayList<Integer>());

    }

    private static void solution(int[] arr, int n, int ind, ArrayList<Integer> list) {
        if (ind==n){
            System.out.println(list);
            return;
        }
        for (int i = ind; i < n; i++) {
            if (i!=ind && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            solution(arr,n,i+1,list);
            list.remove(list.size()-1);
        }
    }

}
