package bintreeds;
import bintreeds.LLStack;
public class ExpTree {
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public Node root=null;
    public void buildExpr(char[] postfix,int size) {
        root = buildExprTree(postfix,size);
    }
    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }
    private Node buildExprTree(char[] postfix,int size) {
        LLStack stack = new LLStack();
        LLStack.Node t, t1, t2;
        for (int i = 0; i < size; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i] - '0');
                stack.push(t);
            } else {
                t = new Node(postfix[i]);
                t1 = stack.pop();
                t2 = stack.pop();
                t.right = t1;
                t.left = t2;
                stack.push(t);
            }
        }
        t = stack.pop();
        return t;
    }
    public int eval(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int l_val = eval(root.left);
        int r_val = eval(root.right);
        if (root.data == '+') {
            return l_val + r_val;
        }
        if (root.data == '-') {
            return l_val - r_val;
        }
        if (root.data == '*') {
            return l_val * r_val;
        }
        return l_val / r_val;
    }
    public void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }
    public void preorder(Node t) {
        if (t != null) {
            System.out.print(t.data + " ");
            preorder(t.left);
            preorder(t.right);
        }
    }
    public void postorder(Node t) {
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.data + " ");
        }
    }
}
