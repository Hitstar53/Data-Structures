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
    public void insertEnd(int data) {
        Node q = new Node(data);
        if(head==null) {
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
    public void removeDup(int n) {
        Node p = head;
        Node q = head;
        while(p!=null && p.next!=null) {
            q=p;
            while(q.next!=null) {
                if(p.data==q.next.data) {
                    q.next = q.next.next;
                    len--;
                }
                else {
                    q = q.next;
                }
            }
            p = p.next;
        }
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
public class prog12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        System.out.print("Enter no .of elements: ");
        int n = sc.nextInt();
        int e;
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++) {
            e = sc.nextInt();
            l.insertEnd(e);
        }
        System.out.println("List: "+l.printList());
        l.removeDup(n);
        System.out.println("New List: "+l.printList());
        sc.close();
    }
}
