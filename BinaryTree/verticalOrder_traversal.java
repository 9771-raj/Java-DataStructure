package BinaryTree;
import java.util.*;
public class verticalOrder_traversal {
    static class pair {
        int hd;  // hd==Horizontal Distance
        TreeNode node;
        pair(int x,TreeNode temp){
            this.hd=x;
            this.node=temp;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.left.left=new TreeNode(7);

        ArrayList<Integer> ans=verticalOrderTraversal(root);
        System.out.println(ans);

    }

    private static ArrayList<Integer> verticalOrderTraversal(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();

        q.add(new pair(0,root));
        while (!q.isEmpty()){
            pair curr=q.poll();
            if (mp.containsKey(curr.hd)){
                mp.get(curr.hd).add(curr.node.data);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(curr.node.data);
                mp.put(curr.hd, arr);
            }
            if (curr.node.left!=null){
                q.add(new pair(curr.hd-1,curr.node.left));
            }
            if (curr.node.right!=null){
                q.add(new pair(curr.hd+1,curr.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Integer>> entry: mp.entrySet()){
            //System.out.println(entry.getValue());
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
