package graphds;
import java.util.*;
public class LLGraph {
    private LinkedList<Integer> adj[];
    public LLGraph(int v) {
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
    }
    public void addEdge(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }
    public void BFS(int s) {
        boolean visited[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;
        while(!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v+" ");
            for(int i: adj[v]) {
                if(!visited[i]) {
                    q.add(i);
                    parent[i] = v;
                    visited[i] = true;
                }
            }
        }
    }
    public void DFS(int s) {
        boolean visited[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        visited[s] = true;
        parent[s] = -1;
        while(!st.isEmpty()) {
            int v = st.pop();
            System.out.print(v+" ");
            for(int i: adj[v]) {
                if(!visited[i]) {
                    st.push(i);
                    parent[i] = v;
                    visited[i] = true;
                }
            }
        }
    }
}
