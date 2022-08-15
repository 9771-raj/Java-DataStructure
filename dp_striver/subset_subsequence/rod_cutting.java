package dp_striver.subset_subsequence;
import java.util.*;
public class rod_cutting {
    public static void main(String[] args) {
        int[] price={4,5,3,2};
        int[] length=new int[price.length];
        for (int i = 0; i < price.length; i++) {
            length[i]=i+1;
        }
        int rod_length=5;
        int ans=recursion_rod_cut(price.length-1,price,length,rod_length);
        System.out.println(ans);
    }

    private static int recursion_rod_cut(int index, int[] price,int[] length, int rod_length) {

        if (index==0){
            if (rod_length%length[0]==0){
                return rod_length/length[0]*price[0];
            }
            else{
                return Integer.MIN_VALUE;
            }
        }

        int not_take=recursion_rod_cut(index-1,price,length,rod_length);
        int take=Integer.MIN_VALUE;
        if (length[index]<=rod_length){
            take=price[index]+recursion_rod_cut(index,price,length,rod_length-length[index]);
        }
        return Math.max(take,not_take);
    }

    /*
    * we can do memoization by just taking the ------------ mem[price.length][rod_length+1]
    * get help from recursion code to make tabulation
    * */

}
