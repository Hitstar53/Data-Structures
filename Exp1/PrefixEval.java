import java.util.Scanner;
import java.lang.Math;
import stackds.IntStack;
public class PrefixEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prefix equation: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        int a, b;
        IntStack s = new IntStack(size);
        try {
            for (int i=size-1;i>=0;i--) {
                if (Character.isDigit(eq[i])) {
                    s.push(eq[i] - '0');
                    System.out.println(s.printStack());
                } else if(eq[i] == '~') {
                    a = s.pop();
                    a = -a;
                    s.push(a);
                } else {
                    a = s.pop();
                    b = s.pop();
                    System.out.println(s.printStack());
                    switch (eq[i]) {
                        case '+':
                            s.push(a+b);
                            System.out.printf("%d+%d = %d\n",a,b,a+b);
                            System.out.println(s.printStack());
                            break;
                        case '-':
                            s.push(a-b);
                            System.out.printf("%d-%d = %d\n",a,b,a-b);
                            System.out.println(s.printStack());
                            break;
                        case '*':
                            s.push(a*b);
                            System.out.printf("%d*%d = %d\n",a,b,a*b);
                            System.out.println(s.printStack());
                            break;
                        case '/':
                            s.push(a/b);
                            System.out.printf("%d/%d = %d\n",a,b,a/b);
                            System.out.println(s.printStack());
                            break;
                        case '^':
                            s.push((int)Math.pow(a,b));
                            System.out.printf("%d^%d = %d\n",a,b,s.Top());
                            System.out.println(s.printStack());
                            break;
                    }
                }
            }
            System.out.println("Result: " + s.Top());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        sc.close();
    }
}