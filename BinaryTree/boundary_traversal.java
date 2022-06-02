package BinaryTree;
import java.util.*;
public class boundary_traversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(9);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(8);

        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(root.data);
        // left part
        leftSide_traversal(root.left,ans);
        // left side leaf
        leafNode_traversal(root.left,ans);
        //right side leaf
        leafNode_traversal(root.right,ans);

        ArrayList<Integer> arr=new ArrayList<>();
        rightSide_traversal(root.right,arr);
        Collections.reverse(arr);


        System.out.println(arr);
        System.out.println(ans);
        ans.addAll(arr);
        System.out.println("Boundary traversal = "+ans);
    }

    private static void rightSide_traversal(TreeNode root, ArrayList<Integer> arr) {
        if ((root==null) || (root.left==null && root.right==null)){
            return;
        }
        arr.add(root.data);
        if (root.right!=null){
            rightSide_traversal(root.right,arr);
        }
        else{
            rightSide_traversal(root.left,arr);
        }



    }

    private static void leafNode_traversal(TreeNode root, ArrayList<Integer> ans) {
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }
        leafNode_traversal(root.left,ans);

        leafNode_traversal(root.right,ans);

    }

    private static void leftSide_traversal(TreeNode root, ArrayList<Integer> ans) {
        if ((root==null) || (root.left==null && root.right==null)){
            return;
        }
        ans.add(root.data);
        if (root.left!=null){
            leftSide_traversal(root.left,ans);
        }
        else{
            leftSide_traversal(root.right,ans);
        }
    }
}
