import java.util.Scanner;
import hashds.OpenHash;
public class HashCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();
        OpenHash hash = new OpenHash(size);
        hash.createHashTable();
        int choice,flag,key;
        while(true) {
            System.out.println("Select an Option:\n1. Insert\t2. Delete\n3. Search\t\4. Display");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    hash.HashInsert(key);
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
