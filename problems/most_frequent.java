package problems;

import java.util.*;

public class most_frequent {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,2,3,4,2,1,3,4,9,7,6,4,3,2,1,1,1,2,3,3,3,3,2,};
        int max_freq_element=brute_force(arr);
        //System.out.println(max_freq_element);
        optimal_soln(arr);
    }

    private static int brute_force(int[] arr) {
        int n=arr.length;
        int count=1;
        int max_count=1;
        int max=arr[0];
        for (int i = 0; i < n; i++) {
            count=1;
            for (int j = i+1; j < n; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
                if(count>max_count){
                    max=arr[i];
                    max_count=count;
                }
            }
            //System.out.println(arr[i]+" -> "+count);
        }
        return max;
    }

    private static void optimal_soln(int[] arr){
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue()
        );
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: hash.entrySet()){
            pq.add(entry);
        }
        System.out.println(pq);
        System.out.println(pq.peek());
    }
}
