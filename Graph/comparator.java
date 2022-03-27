package Graph;
import java.util.*;
class ListNode implements Comparable<ListNode>{
    int id;
    int mark;
    int position;
    ListNode(int x,int y,int z){
        this.id=x;
        this.mark=y;
        this.position=z;
    }
    public int compareTo(ListNode other){
        return this.mark- other.mark;
    }
    public String toString(){
        return "id - "+this.id+" mark - "+this.mark+" position - "+this.position;
    }
}

public class comparator {
    public static void main(String[] args) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>();
        pq.add(new ListNode(1,20,3));
        pq.add(new ListNode(2,10,6));
        pq.add(new ListNode(3,7,8));

        while (!pq.isEmpty()){
            System.out.println(pq.poll().toString());
        }

    }
}
