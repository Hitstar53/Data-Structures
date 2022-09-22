package linkedlistds;
public class LinkedList {
    class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    ListNode head;
    int length;
    public LinkedList() {
        head = null;
    }
    public void clearList() {
        head = null;
        length = 0;
    }
    public void insertAtFront(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        length++;
    }
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        if(head == null) {
            head = newNode;
        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void insertAtPosition(int data, int pos) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        if(pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            for(int i=1;i<pos-1;i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }
    public int deleteAtFront() {
        if(head == null) {
            System.out.println("List is empty");
            return -1;
        } else {
            int data = head.data;
            head = head.next;
            length--;
            return data;
        }
    }
    public int deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty");
            return -1;
        } else {
            ListNode current = head;
            while(current.next.next != null) {
                current = current.next;
            }
            int data = current.next.data;
            current.next = null;
            length--;
            return data;
        }
    }
    public int deleteAtPosition(int pos) {
        ListNode current = head;
        if(pos==1) {
            int data = head.data;
            head = head.next;
            length--;
            return data;
        } else {
            for(int i=1; i<pos-1; i++) {
                current = current.next;
            }
            int data = current.next.data;
            current.next = current.next.next;
            length--;
            return data;
        }
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public String printList() {
        String s = "Head->";
        ListNode current = head;
        while(current != null) {
            s += current.data+(current.next!=null?"->":"");
            current = current.next;
        }
        return s;
    }
    public int getPosition(int data) {
        ListNode current = head;
        int position = 1;
        while(current != null) {
            if(current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }
}
