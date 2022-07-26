package Graph_revision;
import java.util.*;
public class hashmap_comparator {
    class pair implements Comparable<pair>{
        int num;
        pair(int x){
            this.num=x;
        }
       @Override
       public int compareTo(pair other){
            return this.num- other.num;
       }
    }
    public static void main(String[] args) {
        int[] arr={1,1,4,5,6,3,3,5,6,3,2,2,8,5,3};
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1 );
        }
        System.out.println(hash);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->hash.get(a)-hash.get(b));  // gives occurrence num of times of frequent element in the array
        for (Map.Entry<Integer,Integer> mp:hash.entrySet()){
            pq.add(mp.getValue());
        }
        System.out.println(pq);
        System.out.println("most frequent element occurrence = "+pq.peek());

        System.out.println("----------------");

        PriorityQueue<Map.Entry<Integer,Integer>> pq_min=new PriorityQueue<>(
                (a,b)->b.getValue()-a.getValue()); // for max frequent element
                // (a,b)->a.getValue()-b.getValue() // for min frequent element
        for (Map.Entry<Integer,Integer> mp:hash.entrySet()){
            pq_min.add(mp);
        }
        System.out.println(pq_min.peek());


    }
}
