package dp_striver.subset_subsequence;
import java.util.*;
class pair{
    int x;int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class max_length_chain {
    public static void main(String[] args) {
        pair[] arr=new pair[5];
        arr[0]=new pair(5,24);
        arr[1]=new pair(39,60);
        arr[2]=new pair(15,28);
        arr[3]=new pair(27,40);
        arr[4]=new pair(50,90);

        int ans=rec_maxChain(0,-1,arr);
        System.out.println(ans);
    }

    private static int rec_maxChain(int i, int prev, pair[] arr) {

        if (i==arr.length){
            return 0;
        }

        if (prev==-1){
            return Math.max(1+rec_maxChain(i+1,arr[0].y,arr),rec_maxChain(i+1,prev,arr));
        }
        else if (arr[i].x>=prev){
            return Math.max(1+rec_maxChain(i+1,arr[i].y,arr),rec_maxChain(i+1,prev,arr));
        }
        else{
            return rec_maxChain(i+1,prev,arr);
        }
    }
}
