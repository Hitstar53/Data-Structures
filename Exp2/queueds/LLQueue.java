package queueds;
public class LLQueue {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node front=null,rear=null;
    int size=0;
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if(front==null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public int dequeue() {
        if(front==null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = front.data;
            front = front.next;
            size--;
            return data;
        }
    }
    public String printQueue() {
        String s = "[";
        Node temp = front;
        while(temp!=null) {
            s += temp.data+(temp.next!=null?",":"");
            temp = temp.next;
        }
        return s += "]";
    }
    public int front() {
        if(front==null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return front.data;
        }
    }
    public int rear() {
        if(rear==null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return rear.data;
        }
    }
    public boolean isEmptyQueue() {
        return front==null;
    }
    public int size() {
        return size;
    }
}
