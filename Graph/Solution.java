package Graph;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            adj.get(i).add(new ArrayList<>());
        }
        System.out.println(adj);

        //
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(new ArrayList<>());
        }
        System.out.println(arr);
    }
}
