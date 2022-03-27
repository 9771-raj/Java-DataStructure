package Graph_revision;
import java.util.*;
public class priority_queue_hashmap {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,1,2,1,4,5,6,2,4,5,3,4};
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        // this priorityQueue is based on Maxheap
        //Question like top k frequent element
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue()
        );
        // this priorityQueue is based on minheap
        // Question like least frequent element
        PriorityQueue<Map.Entry<Integer,Integer>> pq_minheap=new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):a.getValue()-b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            pq.add(entry);
        }
        System.out.println(pq);
        System.out.println(pq.peek());
        ArrayList<String> a=new ArrayList<>();
        a.add("asd");
        a.add("aed");
        System.out.println(a.contains("asd"));
    }
}
