package BinaryTree;

public class check_sumTree {
    static class pair{
        boolean check;
        int sum;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(1);
//        root.left.left.left=new TreeNode(0);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.left.left=new TreeNode(7);

        pair ans=sum_treeCheck(root);
        System.out.println(ans.check);

    }

    private static pair sum_treeCheck(TreeNode root) {
        if (root==null){
            pair p=new pair();
            p.check=true;
            p.sum=0;
            return p;
        }
        if (root.left==null && root.right==null){
            pair p=new pair();
            p.check=true;
            p.sum= root.data;
            return p;
        }
        pair left=sum_treeCheck(root.left);
        pair right=sum_treeCheck(root.right);

        pair mp=new pair();
        mp.check=(left.sum+right.sum== root.data) && left.check && right.check;
        if (mp.check){
            mp.check=true;
            mp.sum=2* root.data;
        }
        else{
            mp.check=false;
        }
        return mp;
    }
}
