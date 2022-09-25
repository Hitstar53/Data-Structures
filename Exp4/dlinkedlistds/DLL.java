package dlinkedlistds;
public class DLL {
    class Node {
        int data;
        Node next,prev;
        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }
    Node head=null;
    Node tail=null;
    int len;
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        len++;
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        len++;
    }
    public void insertAtPos(int data,int pos) {
        if(pos<1||pos>len+1) {
            System.out.println("Invalid position");
        } else if(pos==1) {
            insertAtFront(data);
        } else if(pos==len+1) {
            insertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for(int i=1;i<pos-1;i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            len++;
        }
    }
    public int deleteAtFront() {
        if(head==null) {
            System.out.println("List is empty");
            return -1;
        } else {
            int data = head.data;
            head = head.next;
            head.prev = null;
            len--;
            return data;
        }
    }
    public int deleteAtEnd() {
        if(head==null) {
            System.out.println("List is empty");
            return -1;
        } else if(len==1) {
            int data = head.data;
            head = null;
            tail = null;
            len--;
            return data;
        } else {
            int data = tail.data;
            tail = tail.prev;
            tail.next = null;
            len--;
            return data;
        }
    }
    public int deleteAtPos(int pos) {
        if(pos<1||pos>len) {
            System.out.println("Invalid position");
            return -1;
        } else if(pos==1) {
            return deleteAtFront();
        } else if(pos==len) {
            return deleteAtEnd();
        } else {
            Node temp = head;
            for(int i=1;i<pos-1;i++) {
                temp = temp.next;
            }
            int data = temp.next.data;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            len--;
            return data;
        }
    }
    public String printList() {
        Node temp = head;
        String s = "head->";
        while(temp!=null) {
            s += temp.data+(temp.next!=null?"->":"");
            temp = temp.next;
        }
        s += "<-tail";
        return s;
    }
    public int getPos(int data) {
        Node temp = head;
        int pos = 1;
        while(temp!=null) {
            if(temp.data==data) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }
}
