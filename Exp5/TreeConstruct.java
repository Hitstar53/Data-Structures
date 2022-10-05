import java.util.Scanner;
import bintreeds.BinTree;
public class TreeConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinTree bt = new BinTree();
        int n,flag,choice;
        System.out.print("Enter no. of elements in tree: ");
        n = sc.nextInt();
        int pre[] = new int[n];
        int in[] = new int[n];
        int post[] = new int[n];
        while(true) {
            System.out.println("Pick Traversal Combo for Construction:\n1. PreOrder & InOrder\n2. InOrder & PostOrder\n3. PreOrder & PostOrder");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter PreOrder: ");
                    for(int i=0;i<n;i++) {
                        pre[i] = sc.nextInt();
                    }
                    System.out.print("Enter InOrder: ");
                    for(int i=0;i<n;i++) {
                        in[i] = sc.nextInt();
                    }
                    bt.buildPreIn(pre,in,n);
                    System.out.print("Tree built successfully!\nPostOrder: ");
                    bt.PostOrder(bt.root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter InOrder: ");
                    for(int i=0;i<n;i++) {
                        in[i] = sc.nextInt();
                    }
                    System.out.print("Enter PostOrder: ");
                    for(int i=0;i<n;i++) {
                        post[i] = sc.nextInt();
                    }
                    bt.buildPostIn(post,in,n);
                    System.out.print("Tree built successfully!\nPreOrder: ");
                    bt.PreOrder(bt.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter PreOrder: ");
                    for(int i=0;i<n;i++) {
                        pre[i] = sc.nextInt();
                    }
                    System.out.print("Enter PostOrder: ");
                    for(int i=0;i<n;i++) {
                        post[i] = sc.nextInt();
                    }
                    bt.buildPrePost(pre,post,n);
                    System.out.print("Tree built successfully!\nInOrder: ");
                    bt.InOrder(bt.root);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
            System.out.println("Do you want to continue? (1/0)");
            flag = sc.nextInt();
            if(flag==0) {
                break;
            }
        }
        sc.close();
    }
}
