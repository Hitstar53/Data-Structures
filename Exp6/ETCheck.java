import java.util.Scanner;
import exptreeds.ExpTree;
public class ETCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpTree et = new ExpTree();
        System.out.print("Enter the postfix expression: ");
        String postfix = sc.nextLine();
        char[] expr = postfix.toCharArray();
        int size = expr.length;
        et.buildExpr(expr,size);
        System.out.println("infix expression is");
        et.inorder(et.root);
        System.out.println();
        System.out.println("prefix expression is");
        et.preorder(et.root);
        System.out.println();
        System.out.println("postfix expression is");
        et.postorder(et.root);
        System.out.println();
        System.out.println("value of expression is " + et.eval(et.root));
        sc.close();
    }
}
