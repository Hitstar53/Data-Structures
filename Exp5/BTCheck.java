import java.util.Scanner;
import bintreeds.BinTree;
public class BTCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinTree bt = new BinTree();
        int choice,flag;
        int n,d;
        while(true) {
            System.out.println("Select 1 operation:\n1. Insert\t2. Delete\n3. PreOrder\t4. InOrder\t5. PostOrder");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter no. of elements to insert: ");
                    n = sc.nextInt();
                    System.out.print("Enter the elements: ");
                    for (int i = 0; i < n; i++) {
                        bt.insert(sc.nextInt());
                    }
                    System.out.print("InOrder: ");
                    bt.InOrder(bt.root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the element to delete: ");
                    d = sc.nextInt();
                    bt.delete(bt.root,d);
                    System.out.print("InOrder: ");
                    bt.InOrder(bt.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("PreOrder: ");
                    bt.PreOrder(bt.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("InOrder: ");
                    bt.InOrder(bt.root);
                    System.out.println();
                    break;
                case 5:    
                    System.out.print("PostOrder: ");
                    bt.PostOrder(bt.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Size of the tree is " + bt.size(bt.root));
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
