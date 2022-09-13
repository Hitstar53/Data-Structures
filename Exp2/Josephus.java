import queueds.*;
public class Josephus {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        CQueue queue = new CQueue(n+1);
        try {
            for(int i=1;i<n+1;i++) {
                queue.enqueue(i);
            }
            while(queue.size() > 1) {
                for(int i=0;i<k-1;i++) {
                    queue.enqueue(queue.dequeue());
                }
                System.out.println("Eliminated: " + queue.dequeue());
            }
            System.out.println("Survivor: " + queue.dequeue());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
