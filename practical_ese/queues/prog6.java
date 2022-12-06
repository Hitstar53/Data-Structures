import java.util.Scanner;
class PQueue {
    class item {
        int data;
        int priority;
        public item(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }
    item[] queue;
    public PQueue(int n) {
        queue = new item[n];
    }
    public void enqueue(int e, int p) throws Exception {
        if(isFull()) {
            throw new Exception("Queue is full!");
        }
        int i;
        for(i=0;i<queue.length;i++) {
            if(queue[i]==null) {
                queue[i] = new item(e,p);
                break;
            }
        }
        for(int j=i;j>0;j--) {
            if(queue[j].priority>queue[j-1].priority) {
                item temp = queue[j];
                queue[j] = queue[j-1];
                queue[j-1] = temp;
            } else {
                break;
            }
        }
    }
    public int dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        int e = queue[0].data;
        for(int i=0;i<queue.length-1;i++) {
            queue[i] = queue[i+1];
        }
        queue[queue.length-1] = null;
        return e;
    }
    public boolean isFull() {
        return queue[queue.length-1]!=null;
    }
    public boolean isEmpty() {
        return queue[0]==null;
    }
    public String printer() {
        String s = "Queue: [";
        for(int i=0;i<queue.length;i++) {
            if(queue[i]!=null) {
                s += queue[i].data+(i!=queue.length-1?",":"");
            }
        }
        return s += "]";
    }
}
public class prog6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue: ");
        int n = sc.nextInt();
        PQueue pq = new PQueue(n);
        int choice,flag;
        while(true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Print");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int e = sc.nextInt();
                    System.out.print("Enter priority: ");
                    int p = sc.nextInt();
                    try {
                        pq.enqueue(e,p);
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued element: "+pq.dequeue());
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(pq.printer());
                    break;
                case 4:
                    System.exit(0);
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
