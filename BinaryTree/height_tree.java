package BinaryTree;
import java.util.*;
public class height_tree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);

        int height=Height(root);

        System.out.println(height);
    }

    private static int Height(TreeNode root) {
        if (root==null){
            return 0;
        }

        return Math.max(Height(root.left),Height(root.right))+1;
    }
}
