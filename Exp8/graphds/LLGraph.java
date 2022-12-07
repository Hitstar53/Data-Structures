package graphds;
import java.util.*;
public class LLGraph {
    private ArrayList<ArrayList<Integer>> adj;
    public LLGraph(int v) {
        adj = new ArrayList<ArrayList<Integer>>(v);
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    public void printGraph() {
        for(int i=0; i<adj.size(); i++) {
            System.out.print(i+" -> ");
            for(int j=0; j<adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public void BFS(int s) {
        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        int[] level = new int[adj.size()];
        Queue<Integer> q = new java.util.LinkedList<Integer>();
        q.add(s);
        parent[s] = -1;
        visited[s] = true;
        level[s] = 0;
        while(!q.isEmpty()) {
            int v = q.remove();
            System.out.println(v+"(level "+level[v]+")");
            for(int i=0;i<adj.get(v).size();i++) {
                int w = adj.get(v).get(i);
                if(!visited[w]) {
                    level[w] = level[v]+1;
                    q.add(w);
                    visited[w] = true;
                    parent[w] = v;
                }
            }
        }
    }
    public void DFS(int s) {
        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        Stack<Integer> st = new Stack<Integer>();
        int dfs[] = new int[adj.size()];
        int[] start = new int[adj.size()];
        int[] end = new int[adj.size()];
        int time = 1,j=0;
        st.push(s);
        start[s] = time;
        visited[s] = true;
        parent[s] = -1;
        dfs[j++] = s;
        while(!st.isEmpty()) {
            int v = st.peek();
            boolean flag = false;
            for(int i=0;i<adj.get(v).size();i++) {
                int w = adj.get(v).get(i);
                if(!visited[w]) {
                    st.push(w);
                    start[w] = ++time;
                    visited[w] = true;
                    parent[w] = v;
                    flag = true;
                    dfs[j] = w;
                    j++;
                    break;
                }
            }
            if(!flag) {
                end[v] = ++time;
                st.pop();
            }
        }
        System.out.println("DFS Traversal:");
        for(int i=0;i<j;i++) {
            System.out.println(dfs[i]+" (start: "+start[dfs[i]]+", end: "+end[dfs[i]]+")");
        }
    }
}
