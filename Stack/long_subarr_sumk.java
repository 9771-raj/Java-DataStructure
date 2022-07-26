package Stack;
import java.util.*;
public class long_subarr_sumk {
    public static void main(String[] args) {
        int[] arr={1, 4 ,3, 3,1,1, 5, 5};
        int target=4;
        // brute force
//        int ans_len=Brute_force(arr,target);
//        System.out.println(ans_len);
        // only for positive integer
//        int ans=lenOfLongSubarr(arr,arr.length,target);
//        System.out.println(ans);
        int ans_has=hash_optimal(arr,target);
        System.out.println(ans_has);
    }

    private static int Brute_force(int[] arr, int target) {
        int len=0;
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for (int j=i;j<arr.length;j++){
                sum+=arr[j];
                if (sum==target){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
    public static int lenOfLongSubarr (int[] A, int N, int K) {  // work only for positive integer
        int i=0;
        int j=0;
        int sum=0;
        int len=0;

        while(j<N){
            sum+=A[j];
            if(sum<K){
                j++;
            }
            else if(sum==K){
                len=Math.max(len,j-i+1);

                j++;
            }
            else{
                //System.out.println(sum);
                while(sum>K){
                    sum-=A[i];
                    i++;
                }
                if(sum==K){
                    len=Math.max(len,j-i+1);
                }
                j++;
            }

        }
        return len;
    }

    private static int hash_optimal(int[] arr,int target){
        HashMap<Integer,Integer> hash=new HashMap<>();
        int len=0;
        int sum=0;
        hash.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            hash.putIfAbsent(sum,i);
            if (hash.containsKey(sum-target) && len< i-hash.get(sum-target)){
                len=i-hash.get(sum-target);
            }
        }
        return len;
    }
}
