package BinaryTree;

public class is_cousins {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);

        int x=4;
        int y=6;
        boolean ans=Triggering(root,x,y);
        System.out.println(ans);
    }
   static int a=-1;
    private static boolean Triggering(TreeNode root, int x, int y) {
        TreeNode temp=root;
        if (temp.data==x || temp.data==y){
            return false;
        }
        // calculate the height of respective integer x and y
        int x_parent=-1;
        int ht_x=Height(temp,x,x_parent,0);
        int x_p=a;
        int y_parent=-1;
        int ht_y=Height(temp,y,y_parent,0);
        int y_p=a;


        if (x_p!=y_p && ht_y==ht_x){
            return true;
        }
        return false;
    }

    private static int Height(TreeNode root, int num,int parent,int height) {
        if (root==null){
            return 0;
        }
        if (root.data==num){
            a=parent;
           return height;
        }
        parent=root.data;

        int left=Height(root.left,num,parent,height+1);
        if (left!=0){
            return left;
        }
        parent=root.data;
        int right=Height(root.right,num,parent,height+1);
        return right;

    }
}
