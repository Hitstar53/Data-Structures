package hashds;
public class OpenHash1 {
    private int[] hashtable;
    private int size;
    int c1,c2;
    public OpenHash1(int size,int c1,int c2) {
        this.size = size;
        hashtable = new int[size];
        this.c1 = c1;
        this.c2 = c2;
    }
    public void createHashTable() {
        for (int i = 0; i < size; i++) {
            hashtable[i] = -1;
        }
    }
    public int quadraticProbe(int key) {
        int i = 0;
        int count=0;
        int index = key%size;
        if(hashtable[index]!=-1) {
            System.out.println("Key inserted at: "+index);
        }
        while (hashtable[index]!=-1) {
            index = (index+(c1*i)+(c2*i*i))%size;
            if(hashtable[index]!=-1) {
                System.out.println("Collision occured at: "+index);
                i++;
                count++;
            }
            if(count>size-1) {
                return -1;
            }
        }
        return index;
    }
    public void HashInsert(int key) {
        int index = quadraticProbe(key);
        if(index!=-1) {
            System.out.println("Key Inserted at: " + index);
            hashtable[index] = key;
        }
        else {
            System.out.println("Element not inserted!");
        }
    }
    public boolean HashSearch(int key) {
        int index = key % size;
        int i = 0;
        while (hashtable[(index + i) % size] != key) {
            if (hashtable[(index + i) % size] == -1) {
                return false;
            }
            i++;
        }
        return true;
    }
    public void HashDelete(int key) {
        int index = key % size;
        int i = 0;
        while (hashtable[(index + i) % size] != key) {
            i++;
        }
        hashtable[(index + i) % size] = -1;
    }
    public void HashDisplay() {
        for (int i = 0; i < size; i++) {
            System.out.print(hashtable[i] + " ");
        }
        System.out.println();
    }
}
