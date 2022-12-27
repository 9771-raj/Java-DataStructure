package BinaryTree;



public class inPlace_sumtree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int x){
            this.data=x;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        transform(root);
        preorder(root);

    }

    private static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static int transform(Node root) {
        if (root==null) return 0;

        int left=transform(root.left);
        int right=transform(root.right);
        int old=root.data;
        root.data=left+right;
        return root.data+old;
    }

}
