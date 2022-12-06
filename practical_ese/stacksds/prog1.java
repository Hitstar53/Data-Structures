import java.util.Scanner;
class LStack {
    class Node {
        char data;
        Node next;
        public Node(char data) {
            this.data = data;
            next = null;
        }
    }
    Node top = null;
    public int size;
    public void push(char e) {
        Node newNode = new Node(e);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public char pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack empty");
        }
        char temp = top.data;
        top = top.next;
        size--;
        return temp;
    }
    public int top() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack empty");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void printer() {
        String s = "Top -> ";
        if(size>0) {
            s+=top.data;
        }
        if(size>1) {
            Node current = top.next;
            while(current!=null) {
                s += ","+current.data;
                current = current.next;
            }
        }
    }
}
public class prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        char[] postfix = new char[size];
        LStack s = new LStack();
        int k=0;
        try {
            for(int i=0;i<size;i++) {
                if(eq[i]!='+' && eq[i]!='-' && eq[i]!='*' && eq[i]!='/' && eq[i]!='^' && eq[i]!='(' && eq[i]!=')') {
                    postfix[k++] = eq[i];
                }
                else if(eq[i]=='(') {
                    s.push(eq[i]);
                }
                else if(eq[i]==')') {
                    while(s.top()!='(') {
                        postfix[k++] = s.pop();
                    }
                    s.pop();
                }
                else {
                    if(s.isEmpty()) {
                        s.push(eq[i]);
                    }
                    else if(eq[i]=='+' || eq[i]=='-') {
                        if(s.top() == '+' || s.top() == '-' || s.top()=='*' || s.top()=='/' || s.top()=='^') {
                            postfix[k++] = s.pop();
                            s.push(eq[i]);
                        }
                        else {
                            s.push(eq[i]);
                        }
                    }
                    else if(eq[i]=='*' || eq[i]=='/') {
                        if(s.top()=='*' || s.top()=='/' || s.top()=='^') {
                            postfix[k++] = s.pop();
                            s.push(eq[i]);
                        }
                        else {
                            s.push(eq[i]);
                        }
                    }
                    else if(eq[i]=='^') {
                        if(s.top()=='^') {
                            postfix[k++] = s.pop();
                            s.push(eq[i]);
                        }
                        else {
                            s.push(eq[i]);
                        }
                    }
                }
            }
            while(!s.isEmpty()) {
                postfix[size-1] = s.pop();
                size--;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Postfix: "+new String(postfix));
        sc.close();
    }
}