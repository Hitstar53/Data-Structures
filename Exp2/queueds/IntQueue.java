package queueds;
public class IntQueue {
    int[] queue;
    int front;
    int rear;
    int capacity;
    public IntQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }
    public void enqueue(int e) throws Exception {
        if(isFullQueue()) {
            throw new Exception("Queue is full!");
        }
        queue[++rear] = e;
    }
    public int dequeue() throws Exception {
        if(isEmptyQueue()) {
            throw new Exception("Queue is empty!");
        }
        return queue[front++];
    }
    public int front() throws Exception {
        if(isEmptyQueue()) {
            throw new Exception("Queue is empty!");
        }
        return queue[front];
    }
    public int rear() throws Exception {
        if(isEmptyQueue()) {
            throw new Exception("Queue is empty!");
        }
        return queue[rear];
    }
    public String printQueue() {
        String s = "[";
        if(size()>0) {
            s += queue[0];
        }
        if(size()>1) {
            for(int i=1;i<size();i++) {
                s += "," + queue[i];
            }
        }
        return s += "]";
    }
    public boolean isEmptyQueue() {
        return rear == -1;
    }
    public boolean isFullQueue() {
        return rear == capacity - 1;
    }
    public int size() {
        return rear+1;
    }
}
