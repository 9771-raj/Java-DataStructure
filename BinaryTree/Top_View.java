package BinaryTree;
import java.util.*;
public class Top_View {
    static class pair{
        int hd;
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
        root.right.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.left.left=new TreeNode(7);

        ArrayList<Integer> ans=top_view(root);
        System.out.println(ans);
    }

    private static ArrayList<Integer> top_view(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        Map<Integer,ArrayList<Integer>> hash=new TreeMap<>();
        q.add(new pair(0,root));

        while (!q.isEmpty()){
            pair cur=q.poll();
            if (hash.containsKey(cur.hd)){
                continue;
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(cur.node.data);
                hash.put(cur.hd, arr);
            }
            if (cur.node.left!=null){
                q.add(new pair(cur.hd-1,cur.node.left));
            }
            if (cur.node.right!=null){
                q.add(new pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Integer>> entry:hash.entrySet()){
            //System.out.println(entry.getValue());
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
