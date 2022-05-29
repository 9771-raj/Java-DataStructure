package BST;
import java.util.*;
class node{
    int data;
    node left;
    node right;
    node(int x){
        this.data=x;
    }
}
class Binary_STREE{
    node temp;
    void insertion(int x){
        temp=addNode(temp,x);
    }
    node addNode(node temp,int val){
        if (temp==null){
            node newnode=new node(val);
            return temp=newnode;
        }
        node newnode=new node(val);
        if (temp.data>val){
            temp.left=addNode(temp.left,val);
        }
        else if (temp.data<val){
            temp.right=addNode(temp.right,val);
        }
        return temp;
    }
    void print(){
        print_inorder(temp);
    }
    void print_inorder(node root){
        if (root==null){
            return;
        }
        print_inorder(root.left);
        System.out.println(root.data);
        print_inorder(root.right);
    }
    // Moris Traversal
    void traversal(){
        ArrayList<Integer> arr=new ArrayList<>();
        morris_traversal(temp,arr);
        System.out.println(arr);
    }

    private void morris_traversal(node root, ArrayList<Integer> arr) {
        node curr=root;
        while (curr!=null){
            node leftnode=curr.left;
            if (leftnode==null){
                arr.add(curr.data);
                curr=curr.right;
            }
            else{
                node rightmostnode=find_right_most(leftnode,curr);
                if (rightmostnode.right==null){   // thread creation
                    rightmostnode.right=curr;
                    curr=curr.left;
                }
                else{                            // thread destroy
                     rightmostnode.right=null;   // child point to its parent so there is thread means already visited
                     arr.add(curr.data);
                     curr=curr.right;
                }
            }
        }
    }

    private node find_right_most(node leftnode,node curr) {
        while (leftnode.right!=null && leftnode.right!=curr){
            leftnode=leftnode.right;
        }
        return leftnode;
    }


}
public class recover_BST {
    public static void main(String[] args) {
        Binary_STREE b=new Binary_STREE();
        b.insertion(9);
        b.insertion(10);
        b.insertion(8);
        b.insertion(12);
        b.insertion(4);
        b.insertion(7);
        b.print();
        b.traversal();
    }
}
