import java.util.Scanner;
class MGraph {
    int[][] graph;
    int vertices;
    public MGraph(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
    }
    public void addEdge(int i,int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;
    }
    public void BFS(int s) {
        int[] visited = new int[vertices];
        int[] level = new int[vertices];
        int[] queue = new int[vertices];
        int front = -1,rear = -1;
        queue[++rear] = s;
        visited[s] = 1;
        level[s] = 0;
        while(front!=rear) {
            int v = queue[++front];
            System.out.println(v+"(level "+level[v]+")");
            for(int i=0;i<vertices;i++) {
                if(graph[v][i]==1 && visited[i]==0) {
                    queue[++rear] = i;
                    visited[i] = 1;
                    level[i] = level[v]+1;
                }
            }
        }
    }
    public void DFS(int s) {
        int[] visited = new int[vertices];
        int[] stack = new int[vertices];
        int[] dfs = new int[vertices];
        int[] start = new int[vertices];
        int[] end = new int[vertices];
        int top=-1,time=1,j=0;
        stack[++top] = s;
        visited[s] = 1;
        start[s] = time;
        dfs[j++] = s;
        while(top!=-1) {
            int v = stack[top];
            boolean flag = false;
            for(int i=0;i<vertices;i++) {
                if(graph[v][i]==1 && visited[i]==0) {
                    stack[++top] = i;
                    visited[i] = 1;
                    start[i] = ++time;
                    dfs[j++] = i;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                end[v] = ++time;
                top--;
            }
        }
        for(int i=0;i<j;i++) {
            System.out.println(dfs[i]+"(start "+start[dfs[i]]+", end "+end[dfs[i]]+")");
        }
    }
    public void printGraph() {
        for(int i=0;i<vertices;i++) {
            for(int j=0;j<vertices;j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
public class prog15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        MGraph g = new MGraph(vertices);
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();
        for(int i=0;i<e;i++) {
            System.out.println("For Edge "+(i+1));
            System.out.print("Enter the source and destination: ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.addEdge(s,d);
        }
        System.out.println("The Graph is:");
        g.printGraph();
        System.out.print("Enter the source for Traversal: ");
        int s = sc.nextInt();
        System.out.println("BFS Traversal:");
        g.BFS(s);
        System.out.println("\nDFS Traversal:");
        g.DFS(s);
        sc.close();
    }
}