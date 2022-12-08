import java.util.Scanner;
class MinHeap {
    int[] heap;
    int len,size;
    public MinHeap(int size) {
        this.len = 0;
        this.size = size;
        this.heap = new int[size];
    }
    public int parent(int i) {
        if(i<=0 || i>=len) {
            return -1;
        }
        return (i-1)/2;
    }
    public int left(int i) {
        return (2*i+1>=len)?-1:2*i+1;
    }
    public int right(int i) {
        return (2*i+2>=len)?-1:2*i+2;
    }
    public void insert(int data) {
        if(len==size) {
            resize();
        }
        len++;
        heap[len-1] = data;
        shiftUp(len-1);
    }
    public void shiftUp(int i) {
        int temp = heap[i];
        while(i>0 && temp<heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    public void resize() {
        int[] old = heap;
        heap = new int[2*size];
        for(int i=0;i<size;i++) {
            heap[i] = old[i];
        }
        size = 2*size;
        old = null;
    }
    public void heapify(int i) {
        int max = i;
        int left = left(i);
        int right = right(i);
        if(left!=-1 && heap[left]<heap[max]) {
            max = left;
        }
        if(right!=-1 && heap[right]<heap[max]) {
            max = right;
        }
        if(max!=i) {
            int temp = heap[i];
            heap[i] = heap[max];
            heap[max] = temp;
            heapify(max);
        }
    }
    public void heapSort(int n) {
        int count = len;
        for(int i=n-1;i>0;i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            len--;
            heapify(0);
        }
        len = count;
    }
    public void printHeap() {
        for (int i=0;i<len;i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class prog19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        MinHeap heap = new MinHeap(n);
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++) {
            int e = sc.nextInt();
            heap.insert(e);
        }
        System.out.print("Heap: ");
        heap.printHeap();
        heap.heapSort(n);
        System.out.println("Sorted heap: ");
        heap.printHeap();
        sc.close();
    }    
}