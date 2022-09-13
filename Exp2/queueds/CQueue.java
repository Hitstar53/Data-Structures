package queueds;
public class CQueue {
    int[] queue;
    int front;
    int rear;
    int capacity;
    public CQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = 0;
    }
    public void enqueue(int e) throws Exception {
        if(isFullQueue()) {
            throw new Exception("Queue is full!");
        }
        rear = (rear+1)%capacity;
        queue[rear] = e;
    }
    public int dequeue() throws Exception {
        if(isEmptyQueue()) {
            throw new Exception("Queue is empty!");
        }
        front = (front+1)%capacity;
        return queue[front];
    }
    public int front() throws Exception {
        return queue[front+1];
    }
    public int rear() throws Exception {
        return queue[rear];
    }
    public String printQueue() {
        String s = "[";
        for(int i=front+1;i<(rear<front?capacity:rear+1);i++) {
            s += queue[i]+(i!=rear?",":"");
        }
        if(rear<front) {
            for(int i=0;i<rear+1;i++) {
                s += queue[i]+(i!=rear?",":"");
            }
        }
        return s += "]";
    }
    public boolean isEmptyQueue() {
        return front == rear;
    }
    public boolean isFullQueue() {
        return (rear+1)%capacity == front;
    }
    public int size() {
        return (rear-front+capacity)%capacity;
    }
}
