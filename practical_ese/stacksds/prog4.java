import java.util.Scanner;
class LStack {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node top=null;
    int size;
    public void push(int e) {
        Node newNode = new Node(e);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        int temp = top.data;
        top = top.next;
        size--;
        return temp;
    }
    public int top() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top==null;
    }
}
public class prog4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Postfix: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        LStack s = new LStack();
        int a,b;
        try {
            for(int i=0;i<size;i++) {
                if(Character.isDigit(eq[i])) {
                    s.push(eq[i]-'0');
                }
                else if(eq[i]=='~') {
                    a = s.pop();
                    a = -a;
                    s.push(a);
                }
                else {
                    b = s.pop();
                    a = s.pop();
                    switch(eq[i]) {
                        case '+':
                            s.push(a+b);
                            break;
                        case '-':
                            s.push(a-b);
                            break;
                        case '*':
                            s.push(a*b);
                            break;
                        case '/':
                            s.push(a/b);
                            break;
                        case '^':
                            s.push((int)Math.pow(a,b));
                            break;
                    }
                }
            }
            System.out.print("Result: "+s.top());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
