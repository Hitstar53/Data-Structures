import java.util.Scanner;
import dlinkedlistds.DLL;
public class DLLCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL d = new DLL();
        int choice,flag,pos;
        while(true) {
            System.out.println(
                    "Select an option:\n1.Insert at front\t2.Insert at pos\n3.Insert at end\n4.Delete at front\t5.Delete at pos\n6.Delete at end");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    d.insertAtFront(sc.nextInt());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 2:
                    System.out.println("Enter the element to be inserted:");
                    int data = sc.nextInt();
                    System.out.println("Enter the Element after which to insert:");
                    pos = d.getPos(sc.nextInt());
                    if (pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        d.insertAtPos(data, pos+1);
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 3:
                    System.out.println("Enter the element to be inserted:");
                    d.insertAtEnd(sc.nextInt());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 4:
                    System.out.println("Deleted element: "+d.deleteAtFront());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 5:
                    System.out.println("Enter the Element to be deleted:");
                    pos = d.getPos(sc.nextInt());
                    if(pos == -1) {
                        System.out.println("Element not found!");
                    } else {
                        System.out.println("Deleted element: "+d.deleteAtPos(pos));
                        System.out.println("The list is: " + d.printList());
                    }
                    break;
                case 6:
                    System.out.println("Deleted element: "+d.deleteAtEnd());
                    System.out.println("The list is: " + d.printList());
                    break;
                case 7:
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
