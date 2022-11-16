package graphds;
class LinkedList {
    class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    ListNode head;
    int length;
    public LinkedList() {
        head = null;
    }
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public String printList() {
        String s = " -> ";
        ListNode current = head;
        while (current != null) {
            s += current.data + (current.next != null ? " " : "");
            current = current.next;
        }
        return s;
    }
    public int getData(int pos) {
        ListNode current = head;
        for (int i = 1; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }
    public boolean isEmpty() {
        return length == 0;
    }
}
class LLQueue {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node front=null,rear=null;
    int size=0;
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if(front==null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public int dequeue() {
        if(front==null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = front.data;
            front = front.next;
            size--;
            return data;
        }
    }
    public boolean isEmptyQueue() {
        return front==null;
    }
}
class LLStack {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node top=null;
    public int size;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        } 
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }
    public int Top() throws Exception {
        if(isEmptyStack()) {
            throw new Exception("Stack is empty!");
        }
        return top.data;
    }
    public boolean isEmptyStack() {
        return top == null;
    }
}
public class LGraph {
    private LinkedList adj[];
    private int vertices;   
    public LGraph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }
    public void addEdge(int s, int d) {
        adj[s].insertAtEnd(d);
        adj[d].insertAtEnd(s);
    }
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i+adj[i].printList());
        }
    }
    public void BFS(int s) {
        boolean visited[] = new boolean[vertices];
        int[] level = new int[vertices];
        LLQueue queue = new LLQueue();
        visited[s] = true;
        queue.enqueue(s);
        level[s] = 0;
        while(!queue.isEmptyQueue()) {
            int current = queue.dequeue();
            System.out.println(current+" at level "+level[current]);
            LinkedList.ListNode temp = adj[current].head;
            while(temp!=null) {
                if(!visited[temp.data]) {
                    visited[temp.data] = true;
                    queue.enqueue(temp.data);
                    level[temp.data] = level[current]+1;
                }
                temp = temp.next;
            }
        }
    }
    public void DFS(int s) {
        boolean visited[] = new boolean[vertices];
        LLStack stack = new LLStack();
        int dfs[] = new int[vertices];
        int[] start = new int[vertices];
        int[] end = new int[vertices];
        int time = 1,current=0,j=0;
        start[s] = time;
        visited[s] = true;
        stack.push(s);
        dfs[j++] = s;
        while(!stack.isEmptyStack()) {
            try {
                current = stack.Top();
                LinkedList.ListNode temp = adj[current].head;
                while(temp!=null) {
                    if(!visited[temp.data]) {
                        visited[temp.data] = true;
                        stack.push(temp.data);
                        dfs[j++] = temp.data;
                        time++;
                        start[temp.data] = time;
                        break;
                    }
                    temp = temp.next;
                }
                if(temp==null) {
                    time++;
                    end[current] = time;
                    stack.pop();
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        for(int i=0;i<dfs.length;i++) {
            System.out.println(dfs[i]+"(start: "+start[dfs[i]]+" end: "+end[dfs[i]]+")");
        }
    }
}