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
}
public class prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        char[] prefix = new char[size];
        LStack s = new LStack();
        int k=size-1;
        try {
            for(int i=size-1;i>=0;i--) {
                if(eq[i]!='+' && eq[i]!='-' && eq[i]!='*' && eq[i]!='/' && eq[i]!='^' && eq[i]!='(' && eq[i]!=')') {
                    prefix[k--] = eq[i];
                }
                else if(eq[i]==')') {
                    s.push(eq[i]);
                }
                else if(eq[i]=='(') {
                    while(s.top()!=')') {
                        prefix[k--] = s.pop();
                    }
                    s.pop();
                }
                else {
                    if(s.isEmpty()) {
                        s.push(eq[i]);
                    }
                    else if(eq[i]=='+' || eq[i]=='-') {
                        if(s.top()=='*' || s.top()=='/' || s.top()=='^') {
                            prefix[k--] = s.pop();
                            s.push(eq[i]);
                        }
                        else {
                            s.push(eq[i]);
                        }
                    }
                    else if(eq[i]=='*' || eq[i]=='/') {
                        if(s.top()=='^') {
                            prefix[k--] = s.pop();
                            s.push(eq[i]);
                        }
                        else {
                            s.push(eq[i]);
                        }
                    }
                    else if(eq[i]=='^') {
                        s.push(eq[i]);
                    }
                }
            }
            while(!s.isEmpty()) {
                prefix[k--] = s.pop();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Prefix: "+new String(prefix));
        sc.close();
    }
}