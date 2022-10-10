import java.util.*;
class expressiontree {
    Node root;
    boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        } else {
            return false;
        }
    }
    Node construct(String postfix) {
        Node t1, t2, temp;
        Stack st = new Stack();
        int countOperator = 0;
        int countOperand = 0;
        for (int i = 0; i < postfix.length(); i++) {
            if (isOperator(postfix.charAt(i))) {
                countOperator++;
            } else {
                countOperand++;
            }
        }
        if ((countOperand != (countOperator + 1))) {
            System.out.println("Entered expression is not a postfix.");
            System.exit(0);
        }
        for (int i = 0; i < postfix.length(); i++) {
            if (!isOperator(postfix.charAt(i))) {
                temp = new Node();
                temp.data = postfix.charAt(i);
                st.push(temp);
            } else {
                if (st.count >= 2 && (countOperand == (countOperator + 1))) {
                    temp = new Node();
                    temp.data = postfix.charAt(i);

                    t1 = st.pop();
                    t2 = st.pop();

                    temp.left = t2;
                    temp.right = t1;

                    st.push(temp);
                } else {
                    System.out.println("Entered expression is not a postfix.");
                    System.exit(0);

                }
            }
        }
        temp = st.pop();
        return temp;
    }
    void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);

    }
    void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data);
        inorder(root.left);
        inorder(root.right);

    }
    void postorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data);

    }
    class Stack {
        int top = -1;
        Node node[] = new Node[20];
        int count;
        Stack() {
            for (int i = 0; i < node.length; i++) {
                node[i] = new Node();
            }
        }
        void push(Node x) {
            node[++top] = x;
            count++;
        }
        Node pop() {
            count--;
            return node[top--];
        }
    }
}
class Node {
    char data;
    Node left, right;
    Node() {
        left = right = null;
    }
}
public class testexpressiontree {
    public static void main(String[] args) {
        expressiontree ext = new expressiontree();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression in postfix form:");
        String str;
        str = sc.next();
        Node root = ext.construct(str);
        System.out.print("Infix expression is: ");
        ext.inorder(root);
        System.out.print("\nPreorder traversal is:");
        ext.preorder(root);
        System.out.print("\nPostorder traversal is:");
        ext.postorder(root);
        System.out.println();
    }
}
