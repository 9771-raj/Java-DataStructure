package LeetCode;
import java.util.*;
public class long_consecutive_sequence {
    public static void main(String[] args) {

        int[] nums={0,0,3,7,2,5,8,4,6,1,1,2,3,4,6,7,11,22,12,1,3,45,56,8};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        if (nums.length<2){
            System.out.println(1);
        }
        int max_len=0;
        int len=0;
        int prev=pq.poll();
        int curr=0;
        while(!pq.isEmpty()){
            curr=pq.poll();
            System.out.println(prev+" "+curr);
            if(curr-prev==1){

                len++;
                max_len=Math.max(len,max_len);
                prev=curr;
            }
            else if (curr-prev==0){
                continue;
            }
            else{
                len=0;
                if (curr-prev==0 || curr-prev==1){
                    max_len+=1;
                }
                prev=curr;
            }

        }

        System.out.println(max_len+1);
    }
}
