package Doubt_solving;
import java.util.*;
class pair implements Comparable<pair>{
    int x,y;
    pair(int a,int b){
        this.x=a;
        this.y=b;
    }

    @Override
    public int compareTo(pair pair) {
        return this.x-pair.x;
    }
}
public class mapping {
    public static void main(String[] args) {
//        ArrayList<pair> ans=new ArrayList<>();
          int[][] arr={{2,10},{1,4},{4,9}};
//        for (int i = 0; i < arr.length; i++) {
//            ans.add(new pair(arr[i][0],arr[i][1]));
//        }
//        Collections.sort(ans);
//        for (var it:ans){
//            System.out.println(it.x+"  "+it.y);
//        }
          Map<Integer,Integer> map=new HashMap<>();
          for (int i=0;i<arr.length;i++){
              map.put(arr[i][0],arr[i][1]);
          }

          for (Map.Entry<Integer,Integer> mp:map.entrySet()){
              System.out.println(mp.getKey()+" "+mp.getValue());
          }

          Map<Integer,Integer> treeMap=new TreeMap<>();
            for (int i=0;i<arr.length;i++){
                treeMap.put(arr[i][0],arr[i][1]);
            }

        for (Map.Entry<Integer,Integer> mp:treeMap.entrySet()){
            System.out.println(mp.getKey()+" "+mp.getValue());
        }



    }
}
