import java.util.Scanner;
class HashTable {
    int[] hashtable;
    int size;
    int c1,c2;
    public HashTable(int size,int c1,int c2) {
        this.size = size;
        hashtable = new int[size];
        this.c1 = c1;
        this.c2 = c2;
    }
    public void createTable() {
        for(int i=0;i<size;i++) {
            hashtable[i] = -1;
        }
    }
    public int quadProbe(int key) {
        int i=0,count=0;
        int index = key%size;
        int temp = index;
        while(hashtable[index]!=-1) {
            index = (temp+(c1*i)+(c2*i*i))%size;
            if(hashtable[index]!=-1) {
                i++;
                count++;
            }
            if(count>size-1) {
                return -1;
            }
        }
        return index;
    }
    public void insert(int key) {
        int index = quadProbe(key);
        if(index!=-1) {
            hashtable[index] = key;
        } 
    }
    public void printer() {
        System.out.println("Index\tKey");
        for(int i=0;i<size;i++) {
            if(hashtable[i]!=-1) {
                System.out.println(i+"\t"+hashtable[i]);
            } else {
                System.out.println(i);
            }
        }
    }
}
public class prog18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();
        System.out.print("Enter c1 and c2: ");
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        HashTable hash = new HashTable(size,c1,c2);
        hash.createTable();
        System.out.print("Enter no. of keys to insert: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            System.out.print("Enter key "+(i+1)+": ");
            int key = sc.nextInt();
            hash.insert(key);
        }
        System.out.println("\nFinal Hash Table: ");
        hash.printer();
        sc.close();
    }
}