package BinarySearchTree;

public class make_BSt {
    Node root;
    make_BSt(){
        root=null;
    }
    public void insertion(int key){
        root=addNode(root,key);
    }

    private Node addNode(Node root, int key) {
        if (root==null){
            return new Node(key);
        }
        if (root.data<key){
            root.right=addNode(root.right,key);
        }
        else if (root.data>key){
            root.left=addNode(root.left,key);
        }
        return root;
    }

    void inorder(Node root){
        if (root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static void main(String[] args) {

        int[] arr={4,5,2,8,7,11};
        make_BSt a=new make_BSt();
        for (int i = 0; i < arr.length; i++) {
            a.insertion(arr[i]);
        }
        a.inorder(a.root);
    }

}
