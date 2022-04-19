package problems;
import java.util.*;
public class last_weight_stone {
    public static void main(String[] args) {
        int[] arr={2,7,4,1,8,12,34,7,8,9,11,2,3,56};
        ArrayList<Integer> stones=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            stones.add(arr[i]);
        }
        while (stones.size()>1){
            int m1=Collections.max(stones);
            int index1=0;
            for (int i=0;i<stones.size();i++){
                if (stones.get(i)==m1){
                    index1=i;
                    stones.remove(index1);
                    break;
                }
            }
            int m2=Collections.max(stones);
            int index2=0;
            for (int i=0;i<stones.size();i++){
                if (stones.get(i)==m2){
                    index2=i;
                    stones.remove(index2);
                    break;
                }
            }
            //System.out.println(stones);
            if (m1!=m2){

               stones.add(Math.abs(m1-m2));
            }
            if(stones.size()==2){
                if(stones.get(0)==stones.get(1)){
                    System.out.println(0);
                }
            }
            //System.out.println(stones);

        }

    }
}
