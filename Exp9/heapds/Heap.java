package heapds;
public class Heap {
    public int[] heap;
    int count,capacity;
    int heap_type;
    public Heap(int capacity,int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }
    public int parent(int i) {
        if(i<=0 || i>=count) {
            return -1;
        }
        return (i-1)/2;
    }
    public int leftChild(int i) {
        int left = 2*i+1;
        if(left>=count) {
            return -1;
        }
        return left;
    }
    public int rightChild(int i) {
        int right = 2*i+2;
        if(right>=count) {
            return -1;
        }
        return right;
    }
    public int getMax() {
        if(count==0) {
            return -1;
        }
        return heap[0];
    }
    public void shiftUp(int i) {
        int temp = heap[i];
        while(i>0 && temp>heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
        printHeap();
    }
    public void shiftDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if(left!=-1 && heap[left]>heap[maxIndex]) {
            maxIndex = left;
        }
        if(right!=-1 && heap[right]>heap[maxIndex]) {
            maxIndex = right;
        }
        if(maxIndex!=i) {
            int temp = heap[i];
            heap[i] = heap[maxIndex];
            heap[maxIndex] = temp;
            shiftDown(maxIndex);
        }
    }
    public int deleteMax() {
        if(count==0) {
            return -1;
        }
        int data = heap[0];
        heap[0] = heap[count-1];
        count--;
        shiftDown(0);
        return data;
    }
    public void insert(int data) {
        if(count==capacity) {
            resizeHeap();
        }
        count++;
        heap[count-1] = data;
        shiftUp(count-1);
    }
    public void resizeHeap() {
        int[] oldHeap = heap;
        heap = new int[2*capacity];
        for(int i=0;i<capacity;i++) {
            heap[i] = oldHeap[i];
        }
        capacity = 2*capacity;
        oldHeap = null;
    }
    public void destroyHeap() {
        heap = null;
        count = 0;
    }
    public void heapSort(int[] A,int n) {
        int old_size = count;
        for(int i=n-1;i>0;i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            count--;
            shiftDown(0);
        }
        count = old_size;
    }
    public void printHeap() {
        for(int i=0;i<count;i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
