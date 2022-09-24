import java.util.Scanner;
class Polynomial {
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
    int getCoeff(Node node) {
        return node.coeff;
    }
    int getExp(Node node) {
        return node.exp;
    }
    public void insertAtEnd(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        Node current = head;
        if (head == null) {
            head = newNode;
        } else {
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
            s += current.coeff+"x^"+current.exp+(current.next!=null?"+":"");
            current = current.next;
        }
        return s;
    }
}
public class PolyMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial();
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
        Polynomial.Node current1 = p1.head;
        Polynomial.Node current2 = p2.head;
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
