package BinaryTree;

public class hasPathSum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.left.left=new TreeNode(7);
//        root.right.left.left.left=new TreeNode(7);
        String str="123";
        


        int target=8;
        boolean ans=PathSum(root,target);
        System.out.println(ans);
    }

    private static boolean PathSum(TreeNode root, int target) {
        if (root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return (target- root.data==0);
        }
        boolean ans1=PathSum(root.left,target- root.data);
        boolean ans2=PathSum(root.right,target-root.data);
        return ans1 || ans2;

    }
}
