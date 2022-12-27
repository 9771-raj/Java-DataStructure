package Arrays_problem;

public class min_jump_to_reach_end {
    public static void main(String[] args) {
        int[] arr={1,3,5,2};
        int ans=min_jump_to_reachEnd(arr);
        System.out.println(ans);
    }

    private static int min_jump_to_reachEnd(int[] arr) {
        int jump=1;
        int step=arr[0];
        int max_reach=arr[0];
        if (arr.length==1) return 0;
        else if (arr[0]==0) return -1;
        else{
            for (int i = 1; i < arr.length; i++) {
                if (i==arr.length-1){
                    return jump;
                }
                max_reach=Math.max(max_reach,arr[i]+i);
                step--;
                if (step==0){
                    jump++;
                    if (i>=max_reach){
                        return -1;
                    }
                    step=max_reach-i;
                }
            }
            return jump;
        }

    }
}
