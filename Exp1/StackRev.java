import java.util.Scanner;
import stackds.IntStack;
public class StackRev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        IntStack s = new IntStack(size);
        int e;
        System.out.printf("Enter %d elements to be pushed: ",size);
        for(int i=0;i<size;i++) {
            e = sc.nextInt();
            s.push(e);
        }
        System.out.println("Data in Reverse order: ");
        for(int i=size-1;i>=0;i--) {
            System.out.printf("%d ",s.peek());
            s.pop();
        }
        sc.close();
    }
}
