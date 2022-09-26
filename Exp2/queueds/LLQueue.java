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
    
}
