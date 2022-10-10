package exptreeds;
class Node {
    char data;
    Node left, right;
    Node(char data) {
        this.data = data;
        left = right = null;
    }
}
class LLStack {
    int top = -1;
    public int size;
    Node node[] = new Node[20];
    LLStack() {
        for (int i = 0; i < node.length; i++) {
            node[i] = new Node(' ');
        }
    }
    void push(Node x) {
        node[++top] = x;
        size++;
    }
    Node pop() {
        size--;
        return node[top--];
    }
}
public class ExpTree {
    public Node root;
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
        Node t, t1, t2;
        for (int i = 0; i < size; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
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
            return root.data-'0';
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
            System.out.print(t.data);
            inorder(t.right);
        }
    }
    public void preorder(Node t) {
        if (t != null) {
            System.out.print(t.data);
            preorder(t.left);
            preorder(t.right);
        }
    }
    public void postorder(Node t) {
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.data);
        }
    }
}
