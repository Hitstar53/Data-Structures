package stackds;
public class IntStack {
    int[] stack;
    int top;
    int capacity;
    public IntStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int e) throws Exception {
        if(isFullStack()) {
            throw new Exception("Stack is full!");
        }
        stack[++top] = e;
    }
    public int pop() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        } 
        return stack[top--];
    }
    public int Top() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        }
        return stack[top];
    }
    public String printStack() {
        String s = "[";
        if(size()>0) {
            s += stack[0];
        }
        if(size()>1) {
            for(int i=1;i<size();i++) {
                s += "," + stack[i];
            }
        }
        return s += "]";
    }
    public boolean isEmptyStack() {
        return top == -1;
    }
    public boolean isFullStack() {
        return top == capacity - 1;
    }
    public int size() {
        return top+1;
    }
}
