import java.util.Scanner;
class LinkedList {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node head=null;
    int len;
    public void insertFront(int data) {
        Node p = new Node(data);
        p.next = head;
        head = p;
        len++;
    }
    public void insertEnd(int data) {
        Node q = new Node(data);
        if(head == null) {
            head = q;
        }
        else {
            Node p = head;
            while(p.next!=null) {
                p = p.next;
            }
            p.next = q;
        }
        len++;
    }
    public int deleteFront() {
        if(head == null) {
            return -1;
        }
        Node p = head;
        head = p.next;
        int data = p.data;
        len--;
        return data;
    }
    public int deleteEnd() {
        if(head == null) {
            return -1;
        }
        Node p = head;
        while(p.next.next!=null) {
            p = p.next;
        }
        int data = p.next.data;
        p.next = null;
        len--;
        return data;
    }
    public int deletePos(int pos) {
        Node p = head;
        int data;
        if(pos<0) {
            return -1;
        }
        if(pos==0) {
            data = head.data;
            head = head.next;
            len--;
            return data;
        } else {
            for(int i=1;i<pos;i++) {
                p = p.next;
            }
            data = p.next.data;
            p.next = p.next.next;
            len--;
            return data;
        }
    }
    public int getPos(int data) {
        Node p = head;
        int pos=0;
        while(p.next!=null) {
            if(p.data==data) {
                System.out.println("Data found at position " + pos);
                return pos;
            }
            p = p.next;
            pos++;
        }
        return -1;
    }
    public String printList() {
        String s = "";
        Node p = head;
        while(p!=null) {
            s += p.data + " ";
            p = p.next;
        }
        return s;
    }
}
public class prog7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        System.out.print("Enter no .of elements: ");
        int n = sc.nextInt();
        int e;
        for(int i=0;i<n;i++) {
            System.out.print("Enter element "+(i+1)+": ");
            e = sc.nextInt();
            l1.insertEnd(e);
            if((i>=n/2 && n%2==0) || (i>=(n/2+1) && n%2!=0)) {
                l2.insertFront(e);
            }
        }
        System.out.println("Given List: "+l1.printList());
        n = n/2;
        LinkedList.Node t1 = l1.head;
        LinkedList.Node t2 = l2.head;
        for(int i=0;i<n;i++) {
            if(t1.data != t2.data) {
                System.out.println("List is not a palindrome!");
                break;
            } else {
                t1 = t1.next;
                t2 = t2.next;   
            }
        }
        sc.close();
    }
}
