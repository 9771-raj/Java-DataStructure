package Sliding_window;

public class min_window_sum {
    public static void main(String[] args) {
        int[] arr={2,3,4,0,6,7,8};
        int k=1;
        int sum=0;
        int ans=solution(arr,sum,k);
        System.out.println(ans);
    }

    private static int solution(int[] arr, int sum, int k) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(i+1>=k){
                if(sum<min){
                    min=sum;
                }
                sum-=arr[i+1-k];
            }

        }
        return min;
    }
}
