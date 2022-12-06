import java.util.Scanner;
class MQueue {
    int[] queue;
    int[] front;
    int[] rear;
    int[] capacity;
    public MQueue(int n,int k) {
        queue = new int[n];
        front = new int[k];
        rear = new int[k];
        capacity = new int[k];
        for(int i=0;i<k;i++) {
            if(i==k-1) {
                capacity[i] = n/k+n%k;
            } else {
                capacity[i] = n/k;
            }
            if(i==0) {
                front[i] = 0;
                rear[i] = -1;
            } else {
                front[i] = front[i-1] + capacity[i-1];
                rear[i] = front[i]-1;
            }
            System.out.println("Queue "+i+" : "+front[i]+" "+rear[i]);
        }
    }
    public void enqueue(int e, int qn) throws Exception {
        if(isFull(qn)) {
            throw new Exception("Queue is full!");
        }
        queue[++rear[qn]] = e;
    }
    public int dequeue(int qn) throws Exception {
        if (isEmpty(qn)) {
            throw new Exception("Queue is empty!");
        }
        return queue[front[qn]++];
    }
    public boolean isFull(int qn) {
        if(qn==capacity.length-1) {
            return rear[qn]==queue.length-1;
        }
        return rear[qn]==capacity[qn]*(qn+1)-1;
    }
    public boolean isEmpty(int qn) {
        return front[qn]>rear[qn];
    }
    public String printer(int qn) {
        String s = "Queue "+qn+": [";
        for(int i=front[qn];i<rear[qn]+1;i++) {
            s += queue[i]+(i!=rear[qn]?",":"");
        }
        return s += "]";
    }
}
public class prog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        System.out.print("Enter no. of queues: ");
        int k = sc.nextInt();
        MQueue queue = new MQueue(n,k);
        int flag,choice;
        while(true) {
            System.out.print("Select a queue: ");
            int qn = sc.nextInt();
            System.out.println("Select an Operation:\n1. Enqueue\t2. Dequeue\n3. Print");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter the element to be enqueued: ");
                    int e = sc.nextInt();
                    try {
                        queue.enqueue(e,qn);
                        System.out.println(queue.printer(qn));
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued element: " + queue.dequeue(qn));
                        System.out.println(queue.printer(qn));
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(queue.printer(qn));
                    break;
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