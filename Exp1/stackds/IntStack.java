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
    public void push(int e) {
        if(isFull()) {
            System.out.println("Stack is full\nPush operation failed");
        } else {
            stack[++top] = e;
        }
    }
    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty\nPop operation failed");
        } else {
            top--;
        }
    }
    public int peek() {
        if(!isEmpty()) {
            return stack[top];
        }
        else {
            System.out.println("Stack is empty\nPeek operation failed");
            return -1;
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
    public int size() {
        return top+1;
    }
}
