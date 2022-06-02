package BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.data=x;
    }
}
public class leetcode_level_order {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        root.right.right.left=new TreeNode(6);
        inorder(root);
//        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
//        level_order(root,result);
//        System.out.println(result);
    }

    private static void level_order(TreeNode root, ArrayList<ArrayList<Integer>> result) {
        TreeNode temp=root;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            ArrayList<Integer> arr=new ArrayList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode x=queue.remove();
                arr.add(x.data);
                if(x.left!=null){
                    queue.add(x.left);
                }
                if(x.right!=null){
                    queue.add(x.right);
                }
            }
            result.add(arr);
        }
    }

    public static void inorder(TreeNode root){
        TreeNode temp=root;
        if(temp==null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.data+" ");
        inorder(temp.right);

    }

}
