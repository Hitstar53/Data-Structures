import java.util.Scanner;
import dlinkedlistds.DLL;
public class DLLCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL d = new DLL();
        int choice,flag,pos,data;
        while(true) {
            System.out.println(
                    "Select an option:\n1.Insert at front\n2.Insert at Right\n3.Insert at left\n4.Insert at end\n5.Delete at front\n6.Delete at right\n7.Delete at left\n8.Delete at end");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter the element to be inserted: ");
                    d.insertAtFront(sc.nextInt());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 2:
                    System.out.print("Enter the element to be inserted: ");
                    data = sc.nextInt();
                    System.out.print("Enter the pos after which to insert: ");
                    pos = sc.nextInt();
                    if (pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        d.insertAtPos(data, pos+1);
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 3:
                    System.out.print("Enter the element to be inserted: ");
                    data = sc.nextInt();
                    System.out.print("Enter the pos before which to insert: ");
                    pos = sc.nextInt();
                    if (pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        d.insertAtPos(data,pos);
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 4:
                    System.out.print("Enter the element to be inserted: ");
                    d.insertAtEnd(sc.nextInt());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 5:
                    System.out.println("Deleted element: "+d.deleteAtFront());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 6:
                    System.out.print("Enter pos after which to delete: ");
                    pos = sc.nextInt();
                    if(pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        System.out.println("Deleted element: "+d.deleteAtPos(pos+1));
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 7:
                    System.out.print("Enter pos before which to delete: ");
                    pos = sc.nextInt();
                    if (pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        System.out.println("Deleted element: " + d.deleteAtPos(pos-1));
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 8:
                    System.out.println("Deleted element: "+d.deleteAtEnd());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 9:
                    System.out.println("The list is: "+d.printList());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println("Do you want to continue?\n1. Yes\t2. No");
            flag = sc.nextInt();
            if (flag == 2) {
                break;
            }
        }
        sc.close();
    }
}
