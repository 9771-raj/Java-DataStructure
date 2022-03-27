package BinaryTree;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        this.data=x;
    }
}
public class binary_tree {
    public static void main(String[] args) {
        Node root=new Node(12);
        root.left=new Node(14);
        root.right=new Node(34);
        root.left.right=new Node(45);
        root.right.right=new Node(9);
        root.left.left=new Node(8);
        root.right.right.right=new Node(80);
        //         12
        //       /    \
        //      14     34
        //     /  \   /  \
        //    8   45 null 9
        //                 \
        //                  80
//        System.out.println("Inorder Traversal ----------");
//        inorder(root);
//        System.out.println();
//        System.out.println("LevelOrder Traversal ----------");
//        levelorder(root);
        leftView(root);
        System.out.println(isValidBST(root));
    }

    private static void levelorder(Node root) {
        Node temp=root;
        Queue<Node> q=new LinkedList<>();
        if(temp==null){
            System.out.println("Tree is Empty ?");
        }
        q.add(temp);
        while (q.size()!=0){
            Node x=q.poll();
            System.out.print(x.data+" ");
            if(x.left!=null){
                q.add(x.left);
            }
            if(x.right!=null){
                q.add(x.right);
            }
        }
    }

    private static void inorder(Node root) {
        Node temp=root;
        if(temp==null){
            return;
        }
        System.out.print(temp.data+" ");
        inorder(temp.left);
        inorder(temp.right);
    }

    private static void leftView(Node root){
        Node temp=root;
        Queue<Node> q=new LinkedList<Node>();
        if(temp==null){
            System.out.println("No tree exists----");
        }
        q.add(temp);
        while (!q.isEmpty()){
            int count=0;
            int size=q.size();
            while(count++ < size){
                Node x=q.poll();
                if(count==1){
                    System.out.println(x.data);
                }
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
        }
    }

    // checking for tree is BST or not
    public static boolean isValidBST(Node root) {
        if(checking(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checking(Node root,int min,int max){
        if(root==null) return true;
        if(root.data<min || root.data>max) return false;
        return checking(root.left,min,root.data) && checking(root.right,root.data,max);
    }
}
