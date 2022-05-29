package Stack;
import java.util.*;
public class daily_temperatures {
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        int[] ans=new int[arr.length];

        ans[arr.length-1]=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(arr.length-1);
        for (int i = arr.length-2; i >=0 ; i--) {
            if(!stack.isEmpty()){
                while (stack.size()>0 && arr[i]>=arr[stack.peek()]){
                    stack.pop();
                }
            }
            ans[i]=stack.isEmpty()?0:Math.abs(i-stack.peek());
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}