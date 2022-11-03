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
        System.out.print("Enter the source for Traversal: ");
        int s = sc.nextInt();
        g.BFS(s);
        sc.close();
    }
}
