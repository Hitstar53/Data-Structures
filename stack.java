package stackds;
public class stack {
    char[] stack;
    int top;
    int capacity;
    public stack(int size) {
        stack = new char[size];
        capacity = size;
        top = -1;
    }
    public void push(char e) {
        if (isFull()) {
            System.out.println("Stack is full\nPush operation failed");
        } else {
            stack[++top] = e;
        }
    }
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty\nPop operation failed");
        } else {
            top-=1;
        }
    }
    public char peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return '0';
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
    public int size() {
        return top + 1;
    }
    public void printStack() {
        for(int i=0;i<=top;i++) {
            System.out.printf("%c ",stack[i]);
        }
    }
}