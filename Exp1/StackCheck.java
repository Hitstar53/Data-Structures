import java.util.Scanner;
import stackds.CharStack;
public class StackCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        CharStack s = new CharStack(size);
        int flag,choice;
        while(true) {
            System.out.println("Select 1 Operation:\n1. Push\t\t2. Pop\n3. Peek\t\t4. Size");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the element to be pushed: ");
                    char e = sc.next().charAt(0);
                    try {
                        s.push(e);
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Stack after push: " + s.printStack());
                    break;
                case 2:
                    try {
                        System.out.println("Popped element: " + s.pop());
                        System.out.println("Stack after pop: " + s.printStack());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("The top element is: " + s.Top());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("The size of the stack is: "+s.size());
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Do you want to continue?\n1. Yes\t2. No");
            flag = sc.nextInt();
            if(flag == 2) {
                break;
            }
        }
        sc.close();
    }
}
