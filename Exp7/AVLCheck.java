import java.util.Scanner;
import avltreeds.AvlTree;
public class AVLCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AvlTree avl = new AvlTree();
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
                        avl.insert(sc.nextInt());
                        System.out.print("Tree (pre): ");
                        avl.PreOrder(avl.root);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter the element to delete: ");
                    d = sc.nextInt();
                    avl.delete(avl.root,d);
                    System.out.print("InOrder: ");
                    avl.InOrder(avl.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("PreOrder: ");
                    avl.PreOrder(avl.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("InOrder: ");
                    avl.InOrder(avl.root);
                    System.out.println();
                    break;
                case 5:    
                    System.out.print("PostOrder: ");
                    avl.PostOrder(avl.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Size of the tree is " + avl.size(avl.root));
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
