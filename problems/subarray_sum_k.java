package problems;
import java.util.*;
//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

public class subarray_sum_k {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(0,1);
        int[] arr={1,2,3,-2,2,3};
        int k=3;
        int sum=0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(hash.containsKey(sum-k)){
                count+=hash.get(sum-k);
            }
            hash.put(sum,hash.getOrDefault(sum,0)+1);
            System.out.println(hash);
        }
        System.out.println(count);

    }
}
