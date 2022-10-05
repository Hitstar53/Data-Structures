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
    public void buildPreIn(int pre[],int in[],int n) {
        root = build1(pre,0,n-1,in,0,n-1);
    }
    private Node build1(int pre[],int preStart,int preEnd,int in[],int inStart,int inEnd) {
        if(preStart>preEnd || inStart>inEnd) {
            return null;
        }
        int rootData = pre[preStart];
        Node temp = new Node(rootData);
        int i;
        for (i=inStart;i<inEnd;i++) {
            if (in[i] == rootData) {
                break;
            }
        }
        temp.left = build1(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
        temp.right = build1(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
        return temp;
    }
    public void buildPostIn(int post[], int in[], int n) {
        root = build2(post,0,n-1,in,0,n-1);
    }
    private Node build2(int post[],int postStart,int postEnd,int in[],int inStart,int inEnd) {
        if(postStart>postEnd || inStart>inEnd) {
            return null;
        }
        int val = post[postEnd];
        Node temp = new Node(val);
        int i;
        for(i=inStart;i<inEnd;i++) {
            if(in[i]==val) {
                break;
            }
        }
        temp.left = build2(post,postStart,postStart+i-inStart-1,in,inStart,i-1);
        temp.right = build2(post,postStart+i-inStart,postEnd-1,in,i+1,inEnd);
        return temp;
    }
    public void buildPrePost(int pre[], int post[], int n) {
        root = build3(pre,0,n-1,post,0,n-1);
    }
    private Node build3(int pre[],int preStart,int preEnd,int post[],int postStart,int postEnd) {
        if(preStart>preEnd || postStart>postEnd) {
            return null;
        }
        int val = pre[preStart-1];
        Node temp = new Node(val);
        if(preStart==preEnd) {
            return temp;
        }
        int i;
        for(i=postStart;i<postEnd;i++) {
            if(post[i]==pre[preStart+1]) {
                break;
            }
        }
        temp.left = build3(pre,preStart+1,preStart+2+i-postStart,post,postStart,i);
        temp.right = build3(pre,preStart+2+i-postStart,preEnd,post,i+1,postEnd-1);
        return temp;
    }
}
