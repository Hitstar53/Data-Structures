package hashds;
import java.util.Scanner;
public class OpenHash {
    Scanner sc = new Scanner(System.in);
    private int[] hashtable;
    private int size;
    public OpenHash(int size) {
        this.size = size;
        hashtable = new int[size];
    }
    public void createHashTable() {
        for (int i = 0; i < size; i++) {
            hashtable[i] = -1;
        }
    }
    public int linearProbe(int key) {
        int index = key%size;
        int i = 0;
        while (hashtable[(index+i)%size] != -1) {
            i++;
        }
        return (index+i)%size;
    }
    public int quadraticProbe(int key) {
        int index = key%size;
        int i = 0;
        while (hashtable[(index+i*i)%size] != -1) {
            i++;
        }
        return (index+i*i)%size;
    }
    public int doubleHashing(int key) {
        int index = key%size;
        int i = 0;
        while (hashtable[(index+i*hashFunction2(key))%size] != -1) {
            i++;
        }
        return (index+i*hashFunction2(key))%size;
    }
    public int hashFunction2(int key) {
        return 7-(key%7);
    }
    public void HashInsert(int key) {
        System.out.println("Which probing technique to use?\n1. Linear\t2. Quadratic\t3. Double Hashing");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                hashtable[linearProbe(key)] = key;
                break;
            case 2:
                hashtable[quadraticProbe(key)] = key;
                break;
            case 3:
                hashtable[doubleHashing(key)] = key;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public boolean HashSearch(int key) {
        int index = key%size;
        int i = 0;
        while (hashtable[(index+i)%size] != key) {
            if (hashtable[(index+i)%size] == -1) {
                return false;
            }
            i++;
        }
        return true;
    }
    public void HashDelete(int key) {
        int index = key%size;
        int i = 0;
        while (hashtable[(index+i)%size] != key) {
            i++;
        }
        hashtable[(index+i)%size] = -1;
    }
    public void HashDisplay() {
        for (int i = 0; i < size; i++) {
            System.out.print(hashtable[i] + " ");
        }
        System.out.println();
    }
}
