import java.util.Scanner;
import graphds.LLGraph;
public class GraphCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();
        LLGraph g = new LLGraph(v);
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();
        for(int i=0; i<e; i++) {
            System.out.println("For Edge "+(i+1));
            System.out.print("Enter the source and destination: ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.addEdge(s,d);
        }
        System.out.println("The Graph is:");
        g.printGraph();
        while(true) {
            System.out.print("Enter the source for Traversal: ");
            int s = sc.nextInt();
            System.out.println("Choose the type of Traversal:\n1. BFS\n2. DFS");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.println("BFS Traversal:");
                    g.BFS(s);
                    break;
                case 2:
                    System.out.println("DFS Traversal:");
                    g.DFS(s);
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
            System.out.print("Do you want to continue? (0=no/1=yes): ");
            int c = sc.nextInt();
            if(c==0) {
                break;
            }
        }
        sc.close();
    }
}
