import java.util.Scanner;
import stackds.stack;
public class postfixeval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size,opr,a,b;
        String equ = new String();
        System.out.print("Enter the equation: ");
        equ = sc.nextLine();
        size = equ.length();
        char[] eq = equ.toCharArray();
        stack s = new stack(size);
        for(int i=0;i<size;i++) {
            if(eq[i] >= '0' && eq[i] <= '9') {
                s.push(eq[i]);
            }
            else {
                if(eq[i]=='+') {
                    s.pop();
                    a = Integer.parseInt(String.valueOf(s.peek()));
                    s.pop();
                    b = Integer.parseInt(String.valueOf(s.peek()));
                    opr = a+b;
                    System.out.printf("%d+%d = %d\n",a,b,opr);
                    s.push((char)opr);
                }
                if(eq[i]=='+') {
                    s.pop();
                    a = Integer.parseInt(String.valueOf(s.peek()));
                    s.pop();
                    b = Integer.parseInt(String.valueOf(s.peek()));
                    opr = b+a;
                    System.out.printf("%d+%d = %d\n",b,a,opr);
                    s.push((char)opr);
                }
                else if(eq[i]=='-') {
                    s.pop();
                    a = Integer.parseInt(String.valueOf(s.peek()));
                    s.pop();
                    b = Integer.parseInt(String.valueOf(s.peek()));
                    opr = b-a;
                    System.out.printf("%d-%d = %d",b,a,opr);
                    s.push((char)opr);
                }
                else if(eq[i]=='*') {
                    s.pop();
                    a = Integer.parseInt(String.valueOf(s.peek()));
                    s.pop();
                    b = Integer.parseInt(String.valueOf(s.peek()));
                    opr = b*a;
                    System.out.printf("%d*%d = %d",b,a,opr);
                    s.push((char)opr);
                }
                else if(eq[i]=='/') {
                    s.pop();
                    a = Integer.parseInt(String.valueOf(s.peek()));
                    s.pop();
                    b = Integer.parseInt(String.valueOf(s.peek()));
                    opr = b/a;
                    System.out.printf("%d/%d = %d",b,a,opr);
                    s.push((char)opr);
                }
            }
        }
        a = Integer.parseInt(String.valueOf(s.peek()));
        System.out.printf("Answer = %d",a);
        sc.close();
    }
}
