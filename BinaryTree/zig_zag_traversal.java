package BinaryTree;
import java.util.*;
public class zig_zag_traversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (root==null){
            System.out.println("tree not found!");
        }
        q.add(root);
        int count=0;
        while (!q.isEmpty()){
            ArrayList<Integer> store=new ArrayList<>();

            for (int i = q.size(); i>0; i--) {
                TreeNode a=q.remove();
                store.add(a.data);
                if (a.left!=null){
                    q.add(a.left);
                }
                if (a.right!=null){
                    q.add(a.right);
                }
            }
            if (count%2!=0){
                Collections.reverse(store);
                ans.add(store);
            }
            else {
                ans.add(store);
            }
            count++;
        }
        System.out.println(ans);
    }
}
