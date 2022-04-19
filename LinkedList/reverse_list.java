package LinkedList;

import java.util.List;

class ListNode{
    private class node{
        int src;
        node next;
        node(int x){
            this.src=x;
            this.next=null;
        }
    }
    node head;
    void addEdge(int val){
        if (head==null){
            node newnode=new node(val);
            head=newnode;
        }
        else{
         node temp=head;
         node newnode=new node(val);
         while (temp.next!=null){
             temp=temp.next;
         }
         temp.next=newnode;
        }
    }
    void traversal(){
        node temp=head;
        while (temp!=null){
            System.out.print(temp.src+" ");
            temp=temp.next;
        }
    }
    void reverse_list(){
        node temp=head;
        node prev=null;
        node current=null;
        while (temp!=null){
            current=temp.next;
            temp.next=prev;
            prev=temp;
            temp=current;
        }
        head=prev;
    }
}
public class reverse_list {
    public static void main(String[] args) {
        ListNode list=new ListNode();
        ListNode list2=new ListNode();
        for (int i = 0; i < 5; i++) {
            list.addEdge(i);
            list2.addEdge(i+1);
        }
        list.traversal();
        list.reverse_list();
        System.out.println();
        list.traversal();


    }

}
