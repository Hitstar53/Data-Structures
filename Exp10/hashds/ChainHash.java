package hashds;
public class ChainHash {
    class HashNode {
        int key;
        HashNode next;
        HashNode(int key) {
            this.key = key;
            this.next = null;
        }
    }
    HashNode[] hashtable;
    int size;
    public ChainHash(int size) {
        this.size = size;
        hashtable = new HashNode[size];
    }
    public void createHashTable() {
        for (int i = 0; i < size; i++) {
            hashtable[i] = null;
        }
    }
    public int hashFunction(int key) {
        return key%size;
    }
    public void HashInsert(int key) {
        int index = hashFunction(key);
        HashNode newNode = new HashNode(key);
        if (hashtable[index] == null) {
            hashtable[index] = newNode;
        } else {
            HashNode temp = hashtable[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public boolean HashSearch(int key) {
        int index = hashFunction(key);
        HashNode temp = hashtable[index];
        while (temp != null) {
            if (temp.key == key) {
                System.out.println("Key found");
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Key not found");
        return false;
    }
    public void HashDelete(int key) {
        int index = hashFunction(key);
        HashNode temp = hashtable[index];
        HashNode prev = null;
        while (temp != null) {
            if (temp.key == key) {
                if (prev == null) {
                    hashtable[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Key deleted");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Key not found");
    }
    public void DeleteHashTable() {
        for (int i = 0; i < size; i++) {
            hashtable[i] = null;
        }
    }
    public void HashDisplay() {
        for (int i = 0; i < size; i++) {
            HashNode node = hashtable[i];
            System.out.print("[" + i + "] ");
            while (node != null) {
                System.out.print(node.key + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
