import java.util.*;
public class polyAdd {
    Node head;
    class Node{
        int cof;
        int exp;
        Node next;
        Node(int cof, int exp){
            this.cof=cof;
            this.exp=exp;
            next=null;
        }
    }

    void addLast(int cof, int exp){
        Node newNode = new Node(cof, exp);
        if(head==null){
            head=newNode;
            return;
        }

        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    void print(){
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.cof+"X^"+currNode.exp+" + ");
            currNode=currNode.next;
        }
        System.out.print("NULL");
    }

    

    public static void main(String [] args){
        polyAdd p1 = new polyAdd();
        polyAdd p2 = new polyAdd();

        polyAdd p3 = new polyAdd();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of terms your 1st polynomial has:");
        int len1=sc.nextInt();
        for(int i=0; i<len1; i++){
            System.out.println("Term"+(i+1));
            System.out.println("Enter coefficent");
            int cof = sc.nextInt();
            System.out.println("Enter exponent");
            int exp = sc.nextInt();
            p1.addLast(cof,exp);
        }

        System.out.println("Enter no. of terms your 2nd polynomial has:");
        int len2=sc.nextInt();
        for(int i=0; i<len2; i++){
            System.out.println("Term"+(i+1));
            System.out.println("Enter coefficent");
            int cof = sc.nextInt();
            System.out.println("Enter exponent");
            int exp = sc.nextInt();
            p2.addLast(cof,exp);
        }
    
        

        Node p = p1.head;
        Node q = p2.head;
        while(p!=null&& q!=null){
            if(p.exp==q.exp){
                p3.addLast(p.cof+q.cof, p.exp);
                p=p.next;
                q=q.next;
            }
            else{
                if(p.exp>q.exp){
                    p3.addLast(p.cof, p.exp);
                    p=p.next;
                }else{
                    p3.addLast(q.cof, q.exp);
                    q=q.next;
                }
            }
        }

        while(p!=null){
            p3.addLast(p.cof, p.exp);
            p=p.next;
        }
        while(q!=null){
            p3.addLast(q.cof, q.exp);
            q=q.next;
        }
        
        System.out.println("Polynomial 1");
        p1.print();
        System.out.println();
        System.out.println("Polynomial 2");
        p2.print();
        System.out.println();
        System.out.println("Final Answer:");
        p3.print();

    }
}
