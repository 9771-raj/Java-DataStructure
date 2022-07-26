package Graph_revision;
import java.util.*;
public class min_max_heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(); // default priorityQueue implement minheap
        int[] arr={12,3,4,5,2};
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        System.out.println(pq.peek());              // in minheap peek() function get smallest of all element heap remove through root element
        System.out.println(pq.poll());        // poll() function for deletion
        System.out.println(pq.peek());

        // MaxHeap
        PriorityQueue<Integer> pq_m=new PriorityQueue<>((a,b)->b-a); // maxHeap
        // we can use in place of (a,b)->b-a   == Collections.reverseOrder()
        for (int i = 0; i < arr.length; i++) {
            pq_m.add(arr[i]);
        }
        System.out.println(pq_m.peek());



        // use hashmap in priorityQueue
        PriorityQueue<Map.Entry<Integer,Integer>> pq_map=new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
                );
        Map<Integer,Integer> hash=new HashMap<>();
        int[] nums={1,2,3,1,3,4,5,4,6,7,2,1,3,5};
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> i:hash.entrySet()){
            pq_map.add(i);
        }
        System.out.println(pq_map);
        System.out.println(pq_map.peek());
    }
}
