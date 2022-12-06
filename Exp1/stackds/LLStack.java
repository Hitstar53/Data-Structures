package stackds;
public class LLStack {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node top=null;
    public int size;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        } 
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }
    public int Top() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        }
        return top.data;
    }
    public String printStack() {
        String s = "Top->[";
        if(size>0) {
            s += top.data;
        }
        if(size>1) {
            Node current = top.next;
            while(current != null) {
                s += "," + current.data;
                current = current.next;
            }
        }
        return s += "]";
    }
    public boolean isEmptyStack() {
        return top == null;
    }
}