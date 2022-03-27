package divide_conquere;
import java.util.*;
public class Leetcode {
    public static void main(String[] args) {
        int[] num1={4,9,9,5};
        int[] num2={9,4,9,8,4};
        HashMap<Integer,Integer> hash1=new HashMap<>();
        HashMap<Integer,Integer> hash2=new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            hash1.put(num1[i],hash1.getOrDefault(num1[i],0)+1);
        }
        for (int i = 0; i < num2.length; i++) {
            hash2.put(num2[i],hash2.getOrDefault(num2[i],0)+1);
        }
        ArrayList<Integer> arr=new ArrayList<>();

        for (Integer i:hash1.keySet()){
            if(hash2.containsKey(i)){
                int small=0;
                if(hash2.get(i)<hash1.get(i)){
                    small=hash2.get(i);
                }
                else{
                    small=hash1.get(i);
                }
                for (int j = 0; j < small; j++) {
                    arr.add(i);
                }
            }
        }
        int k=0;
        int[] ans=new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[k++]=arr.get(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
