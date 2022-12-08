import java.util.Scanner;
class Polynom {
    class Node {
        int coeff;
        int exp;
        Node next;
        Node(int coeff, int exp) {
            this.coeff = coeff;
            this.exp = exp;
            next = null;
        }
    }
    Node head;
    public void insertAtEnd(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public String printList() {
        String s = "";
        Node current = head;
        while (current != null) {
            if(current.exp==0) {
                s+=current.coeff;
            } else {
                s += current.coeff+"x^"+current.exp+(current.next!=null?"+":"");
            }
            current = current.next;
        }
        return s;
    }
}
public class PolyMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom p3 = new Polynom();
        int n,m,coeff,exp;
        System.out.print("Enter the no. of terms in 1st polynomial: ");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.print("Enter coeff & exp: ");
            coeff = sc.nextInt();
            exp = sc.nextInt();
            p1.insertAtEnd(coeff, exp);
        }
        System.out.print("Enter the no. of terms in 2nd polynomial: ");
        m = sc.nextInt();
        for(int i=0;i<m;i++) {
            System.out.print("Enter coeff & exp: ");
            coeff = sc.nextInt();
            exp = sc.nextInt();
            p2.insertAtEnd(coeff, exp);
        }
        System.out.println("1st polynomial: "+p1.printList());
        System.out.println("2nd polynomial: "+p2.printList());
        Polynom.Node current1 = p1.head;
        Polynom.Node current2 = p2.head;
        while (current1 != null) {
            while (current2 != null) {
                p3.insertAtEnd(current1.coeff*current2.coeff, current1.exp+current2.exp);
                current2 = current2.next;
            }
            current1 = current1.next;
            current2 = p2.head;
        }
        System.out.println("Solution: "+p3.printList());
        sc.close();
    }
}
