import java.util.Scanner;
import graphds.MatrixGraph;
public class GraphCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        MatrixGraph g = new MatrixGraph(n);
        System.out.println("Enter the edges: ");
        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u == -1 && v == -1) {
                break;
            }
            g.addEdge(u, v);
        }
        System.out.println("The adjacency matrix is: ");
        g.display();
    }
}
