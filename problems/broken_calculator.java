package problems;
import java.util.*;
public class broken_calculator {
    public static void main(String[] args) {
        int min=Integer.MAX_VALUE;
        solution(5,10);
    }

    private static int solution(int src, int target) {

        if (src==target){
            return 0;
        }
         return Math.min(solution(src*2,target),solution(src-1,target))+1;

    }
}
