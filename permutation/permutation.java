package permutation;
import java.util.*;
public class permutation {
    public static void main(String[] args) {
        int[] data={1,2,3};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> comb=new ArrayList<>();
        comb.add(1);
        comb.add(2);
        comb.add(3);
        permute(data,ans, 0);
        System.out.println(ans);
        System.out.println(ans.contains(comb));
    }

    private static void permute(int[] data, ArrayList<ArrayList<Integer>> ans,int index) {
        //base case
        if (index== data.length){
            ArrayList<Integer> a=new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                a.add(data[i]);
            }
            ans.add(new ArrayList<>(a));
            //System.out.println(Arrays.toString(arr));
            return;
        }
        for (int j = index; j < data.length; j++) {
            swaping(data,index,j);
            permute(data,ans,index+1);
            swaping(data,index,j);
        }
    }

    private static void swaping(int[] data, int i, int j) {
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
        //System.out.println(temp);
    }
}
