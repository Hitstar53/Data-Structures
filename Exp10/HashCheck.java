import java.util.Scanner;
import hashds.OQHash;
public class HashCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();
        System.out.print("Enter c1 and c2: ");
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        OQHash hash = new OQHash(size,c1,c2);
        hash.createHashTable();
        int choice,flag,key;
        while(true) {
            System.out.println("Select an Option:\n1. Insert\t2. Delete\t3. Search\t4. Display");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter no. of keys to insert: ");
                    int n = sc.nextInt();
                    for (int i=0;i<n;i++) {
                        System.out.print("Enter key "+(i+1)+": ");
                        key = sc.nextInt();
                        hash.HashInsert(key);
                    }
                    System.out.println("\nFinal Hash Table: ");
                    hash.HashDisplay();
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    key = sc.nextInt();
                    hash.HashDelete(key);
                    System.out.println("Hash table after deletion:");
                    hash.HashDisplay();
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    hash.HashSearch(key);
                    break;
                case 4:
                    System.out.println("Hash table:");
                    hash.HashDisplay();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue?(1/0): ");
            flag = sc.nextInt();
            if (flag == 0) {
                break;
            }
        }
        sc.close();
    }
}
