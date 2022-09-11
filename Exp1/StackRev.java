import java.util.Scanner;
import stackds.IntStack;
public class StackRev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        IntStack s = new IntStack(size);
        int e,i;
        System.out.printf("Enter %d elements to be pushed: ",size);
        try { 
            for(i=0;i<size;i++) {
                e = sc.nextInt();
                s.push(e);
            }
        } catch(Exception ex) {
                System.out.println(ex.getMessage());
        }
        System.out.println("Data in Reverse order: ");
        try {
            for(i=size-1;i>=0;i--) {
                System.out.printf("%d ", s.Top());
                s.pop();   
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        sc.close();
    }
}