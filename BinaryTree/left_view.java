package BinaryTree;
import java.util.*;
public class left_view {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        root.right.right.left=new TreeNode(6);
//        root.left.left=new TreeNode(4);
//        root.left.left.left=new TreeNode(0);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.left.left=new TreeNode(7);
//        root.right.left.left.left=new TreeNode(7);

        Left_view(root);
        //System.out.println(ans);
    }

    private static void Left_view(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            ArrayList<Integer> arr=new ArrayList<>();

            for (int i=q.size();i>0;i--){
                TreeNode cur=q.poll();
                if (arr.size()<1){
                    arr.add(cur.data);
                }
                if (cur.left!=null){
                    q.add(cur.left);
                }
                if (cur.right!=null){
                    q.add(cur.right);
                }
            }
            System.out.println(arr);
        }
    }
}
