package slinkedlistds;
public class CLL {
    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    ListNode head;
    int length;
    public void clearList() {
        head = null;
        length = 0;
    }
    public void insertAtFront(int data) {
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
        length++;
    }
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
            head = newNode;
        }
        length++;
    }
    public void insertAtPos(int data, int pos) {
        ListNode newNode = new ListNode(data);
        if(pos==1) {
            newNode.next = head.next.next;
            head.next = newNode;
        }
        else {
            ListNode current = head.next;
            for(int i=1; i<pos-1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }
    public void deleteAtFront() {
        if(head == null) {
            System.out.println("List is empty");
        } else {
            head.next = head.next.next;
            length--;
        }
    }
    public void deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty");
        } else {
            ListNode current = head.next;
            while(current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = current;
            length--;
        }
    }
    public void deleteAtPos(int pos) {
        if(pos==1) {
            head.next = head.next.next;
        }
        else {
            ListNode current = head.next;
            for(int i=1; i<pos-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        length--;
    }
    public String printList() {
        String s = "";
        ListNode current = head;
        while (current != head) {
            s += current.data + (current.next != null ? "->" : "");
            current = current.next;
        }
        return s+"->Head";
    }
}
