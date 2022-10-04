import java.util.Scanner;
import bintreeds.BinTree;
public class BTCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinTree bt = new BinTree();
        System.out.print("Enter no. of elements to insert: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            bt.inserter(bt.root,sc.nextInt());
        }
        System.out.print("PreOrder: ");
        bt.PreOrder(bt.root);
        System.out.println();
        //System.out.print("InOrder: ");
        //bt.InOrder(bt.root);
        //System.out.println();
        //System.out.print("PostOrder: ");
        //bt.PostOrder(bt.root);
        //System.out.println();
        System.out.print("Enter the element to delete: ");
        int d = sc.nextInt();
        bt.delete(bt.root,d);
        System.out.print("InOrder: ");
        bt.InOrder(bt.root);
        System.out.println();
        System.out.println("Size of the tree is " + bt.size(bt.root));        
    }
}
