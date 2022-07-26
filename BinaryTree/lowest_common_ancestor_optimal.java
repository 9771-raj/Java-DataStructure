package BinaryTree;

public class lowest_common_ancestor_optimal {
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

        int num1=3;
        int num2=6;

        TreeNode ans=LCA_optimised(root,num1,num2);
        System.out.println(ans.data);

    }

    private static TreeNode LCA_optimised(TreeNode root, int p, int q) {
        if (root==null || root.data==p || root.data==q){
            return root;
        }
        TreeNode left=LCA_optimised(root.left,p,q);
        TreeNode right=LCA_optimised(root.right,p,q);
        if (left==null){
            return right;
        }
        else if (right==null){
            return left;
        }else
        return root;
    }
}
