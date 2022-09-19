package linkedlistds;
class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data) {
        this.data = data;
        next = null;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}
public class LinkedList {
    public ListNode head;
    private int length;
    public LinkedList() {
        head = null;
    }
    public ListNode getHead() {
        return head;
    }
    public void clearList() {
        head = null;
        length = 0;
    }
    public void insertAtFront(int data) {
        ListNode newNode = new ListNode(data);
        newNode.setNext(head);
        head = newNode;
        length++;
    }
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        length++;
    }
    public void insertAtPosition(int data, int position) {
        if(position < 0) {
            position = 0;
        }
        if(position > length) {
            position = length;
        }
        if(head == null) {
            head = new ListNode(data);
        } else if(position == 0) {
            ListNode newNode = new ListNode(data);
            newNode.setNext(head);
            head = newNode;
        } else {
            ListNode current = head;
            for(int i=1;i<position;i++) {
                current = current.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        length++;
    }
    public int deleteAtFront() {
        int data = head.getData();
        head = head.getNext();
        length--;
        return data;
    }
    public int deleteAtEnd() {
        ListNode current = head;
        ListNode previous = null;
        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        int data = current.getData();
        previous.setNext(null);
        length--;
        return data;
    }
    public int deleteAtPosition(int position) {
        if(position < 0) {
            position = 0;
        }
        if(position > length) {
            position = length;
        }
        ListNode current = head;
        ListNode previous = null;
        for(int i=1;i<position;i++) {
            previous = current;
            current = current.getNext();
        }
        int data = current.getData();
        previous.setNext(current.getNext());
        length--;
        return data;
    }
    public int size() {
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public String printList() {
        String s = "[";
        ListNode current = head;
        while(current != null) {
            s += current.getData()+(current.getNext()!=null?",":"");
            current = current.getNext();
        }
        return s += "]";
    }
    public int getPosition(int data) {
        ListNode current = head;
        int position = 0;
        while(current != null) {
            if(current.getData() == data) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }
}
