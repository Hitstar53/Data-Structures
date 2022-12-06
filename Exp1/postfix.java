import java.util.Scanner;
import stackds.CharStack;
public class postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String exp = sc.nextLine();
        int size = exp.length();
        char[] eq = exp.toCharArray();
        char[] postfix = new char[size];
        CharStack s = new CharStack(size);
        int k=0;
        try {    
            for (int i = 0; i < size; i++) {
                if(eq[i]!='+' && eq[i]!='-' && eq[i]!='*' && eq[i]!='/' && eq[i]!='^' && eq[i]!='(' && eq[i]!=')') {
                    postfix[k++] = eq[i];
                }
                else if(eq[i] == '(') {
                    s.push(eq[i]);
                    System.out.println(s.printStack());
                } else if(eq[i] == ')') {
                    while(s.Top() != '(') {
                        postfix[k++] = s.pop();
                        System.out.println(s.printStack());
                    }
                    s.pop();
                    System.out.println(s.printStack());
                }
                else {
                    if(s.isEmptyStack()) {
                        s.push(eq[i]);
                        System.out.println(s.printStack());
                    } 
                    else {
                        if(eq[i]=='+' || eq[i]=='-'){
                            if(s.Top() == '+' || s.Top() == '-' || s.Top()=='*' || s.Top()=='/' || s.Top()=='^') {
                                postfix[k++] = s.pop();
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
                            if(s.Top()=='*' || s.Top()=='/' || s.Top()=='^') {
                                postfix[k++] = s.pop();
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
                            if(s.Top()=='^') {
                                postfix[k++] = s.pop();
                                System.out.println(s.printStack());
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            } 
                            else {
                                s.push(eq[i]);
                                System.out.println(s.printStack());
                            }
                        }
                    }
                }
            }
            while (!s.isEmptyStack()) {
                postfix[size - 1] = s.pop();
                size--;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Postfix expression: " + new String(postfix));
        sc.close();
    }
}