package Doubt_solving;
import java.util.*;
public class LOT_doubt {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            q.add(i+5);
        }
        System.out.println(q);
        for (int i=q.size();i>0;i--){
            int num=q.remove();
            System.out.println(i);
        }
    }
}
