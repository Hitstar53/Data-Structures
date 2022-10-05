package bintreeds;
public class BinTree {
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public Node root=null;
    public void insert(int data) {
        root = inserter(root, data);
    }
    private Node inserter(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = inserter(root.left, data);
        } else if (data > root.data) {
            root.right = inserter(root.right, data);
        }
        return root;
    }
    public void delete(Node root,int data) {
        root = deleter(root, data);
    }
    private Node deleter(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleter(root.left, data);
        } else if (data > root.data) {
            root.right = deleter(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleter(root.right, root.data);
        }
        return root;
    }
    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    public int size(Node root) {
        if (root == null)
            return 0;
        else
            return (size(root.left) + 1 + size(root.right));
    }
    public void PreOrder(Node root) {
        if (root!=null) {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    public void InOrder(Node root) {
        if (root!=null) {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }
    public void PostOrder(Node root) {
        if (root!=null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
