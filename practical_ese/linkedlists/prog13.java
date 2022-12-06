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
    int len=0;
    public void insert(int data) {
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
public class prog13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();
        System.out.print("Enter no .of elements: ");
        int n = sc.nextInt();
        int e;
        System.out.print("Enter elements: ");
        for (int i=0;i<n;i++) {
            e = sc.nextInt();
            l1.insert(e);
        }
        System.out.println("List: "+l1.printList());
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        LinkedList.Node t1 = l1.head;
        while(t1!=null) {
            if(t1.data<x) {
                l2.insert(t1.data);
            } else {
                l3.insert(t1.data);
            }
            t1 = t1.next;
        }
        LinkedList.Node t3 = l3.head;
        while(t3!=null) {
            l2.insert(t3.data);
            t3 = t3.next;
        }
        System.out.println("Sorted list: "+l2.printList());
        sc.close();
    }
}
