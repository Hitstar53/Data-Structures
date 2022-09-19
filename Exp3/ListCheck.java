import java.util.Scanner;
import linkedlistds.LinkedList;
public class ListCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create linkedlist and test all functions
        LinkedList list = new LinkedList();
        System.out.println("Enter the number of elements to be inserted at the front of the list");
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Enter the element to be inserted");
            int data = sc.nextInt();
            list.insertAtFront(data);
        }
        System.out.println("Enter the number of elements to be inserted at the end of the list");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Enter the element to be inserted");
            int data = sc.nextInt();
            list.insertAtEnd(data);
        }
        System.out.println("Enter the number of elements to be inserted at a position in the list");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Enter the element to be inserted");
            int data = sc.nextInt();
            System.out.println("Enter the position at which the element is to be inserted");
            int position = sc.nextInt();
            list.insertAtPosition(data, position);
        }
        System.out.println("Enter the number of elements to be deleted from the front of the list");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("The element deleted is " + list.deleteAtFront());
        }
        System.out.println("Enter the number of elements to be deleted from the end of the list");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("The element deleted is " + list.deleteAtEnd());
        }
        System.out.println("Enter the number of elements to be deleted from a position in the list");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Enter the position from which the element is to be deleted");
            int position = sc.nextInt();
            System.out.println("The element deleted is " + list.deleteAtPosition(position));
        }
        System.out.print("The list is: "+list.printList());
        System.out.print("The length of the list is: " + list.size());
        System.out.println("The list is cleared");
        list.clearList();
        System.out.print("The list is: "+list.printList());
        sc.close();
    }
}
