import java.util.Scanner;
import stackds.CharStack;
public class Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        char[] prefix = new char[size];
        CharStack s = new CharStack(size);
        //char[] pr = { '+', '-', '*', '/', '^' };
        int k=0;
        try {    
            for (int i=size-1;i>=0;i--) {
                if(eq[i]!='+' && eq[i]!='-' && eq[i]!='*' && eq[i]!='/' && eq[i]!='^' && eq[i]!='(' && eq[i]!=')') {
                    prefix[k++] = eq[i];
                }
                else if(eq[i] == ')') {
                    s.push(eq[i]);
                    System.out.println(s.printStack());
                } else if(eq[i] == '(') {
                    while(s.Top() != ')') {
                        prefix[k++] = s.pop();
                        System.out.println(s.printStack());
                    }
                    s.pop();
                    System.out.println(s.printStack());
                }
                else {
                    if(s.isEmptyStack()){
                        s.push(eq[i]);
                        System.out.println(s.printStack());
                    } 
                    else{
                        if(eq[i]=='+' || eq[i]=='-') {
                            if(s.Top()=='*' || s.Top()=='/' || s.Top()=='^') {
                                prefix[k++] = s.pop();
                                System.out.println(s.printStack());
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            }
                            else {
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            }
                        }
                        else if(eq[i]=='*' || eq[i]=='/') {
                            if(s.Top()=='^') {
                                prefix[k++] = s.pop();
                                System.out.println(s.printStack());
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            }
                            else {
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            }
                        }
                        else if(eq[i]=='^') {
                            s.push(eq[i]);
                            System.out.println(s.printStack());
                        }
                    }
                }
            }
            while (!s.isEmptyStack()) {
                prefix[size - 1] = s.pop();
                size--;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for(int i=prefix.length-1;i>=0;i--) {
            System.out.print(prefix[i]);
        }
        sc.close();
    }
}
