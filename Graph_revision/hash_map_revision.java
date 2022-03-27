package Graph_revision;
import java.util.*;
public class hash_map_revision {
    public static void main(String[] args) {
        Map<Integer,Integer> hash=new HashMap<>();
        int[] arr={1,2,3,1,3,4,5,4,6,7,2,1,3,5};
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        System.out.println(hash);
        // use contains key and value functions
        boolean a=hash.containsKey(3);
        boolean b=hash.containsValue(9);
        System.out.println(a+" "+b);

        // hashmap iterations
        // iterate through keys only
        for(Integer i: hash.keySet()){
            System.out.println(i+" "+hash.get(i));
        }
        // iterate only values
        for (Integer i:hash.values()){
            System.out.print(i+" ");
        }
        // itearate key/values both
        System.out.println("Entryset");
        for (Map.Entry<Integer,Integer> i:hash.entrySet()){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}
