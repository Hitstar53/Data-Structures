import java.util.Scanner;
import java.lang.Math;
import stackds.IntStack;
public class PostfixEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix equation: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        int a,b;
        IntStack s = new IntStack(size);
        try {
            for(int i=0;i<size;i++) {
                if(Character.isDigit(eq[i])) {
                    s.push(eq[i]-'0');
                } else if(eq[i] == '~') {
                    a = s.pop();
                    a = -a;
                    s.push(a);
                } else {
                    b = s.pop();
                    a = s.pop();
                    switch(eq[i]) {
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
                            System.out.printf("%d/%d = %d\n", a, b, a / b);
                            System.out.println(s.printStack());
                            break;
                        case '^':
                            s.push((int)Math.pow(a,b));
                            System.out.printf("%d^%d = %d\n", a, b, s.Top());
                            System.out.println(s.printStack());
                            break;
                    }
                }
            }
            System.out.println("Result: "+s.Top());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        sc.close();
    }
}
