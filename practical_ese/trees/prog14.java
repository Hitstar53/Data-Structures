import java.util.Scanner;
class BSTree {
    class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root=null;
    public void insert(int data) {
        root = inserter(root,data);
    }
    public Node inserter(Node root,int data) {
        if(root==null) {
            root = new Node(data);
            return root;
        }
        else if(data<root.data) {
            root.left = inserter(root.left,data);
        }
        else if(data>root.data) {
            root.right = inserter(root.right,data);
        }
        return root;
    }
    public void preOrder(Node root) {
        if(root!=null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(Node root) {
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public void postOrder(Node root) {
        if(root!=null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
}
public class prog14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTree bst = new BSTree();
        System.out.print("Enter no. of elements to insert: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++) {
            bst.insert(sc.nextInt());
        }
        System.out.print("InOrder: ");
        bst.inOrder(bst.root);
        System.out.print("\nPostOrder: ");
        bst.postOrder(bst.root);
        System.out.print("\nPreOrder: ");
        bst.preOrder(bst.root);
        sc.close();
    }    
}
