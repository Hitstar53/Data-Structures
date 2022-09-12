import java.util.Scanner;
import queueds.CQueue;
public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int n = sc.nextInt();
        CQueue cq = new CQueue(n);
        int flag,choice;
        while(true) {
            System.out.println("Do you want to continue?\n1. Yes\t2. No");
            flag = sc.nextInt();
            if (flag == 2) {
                break;
            }
        }
        sc.close();
    }
}
