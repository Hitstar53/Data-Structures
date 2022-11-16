import java.util.Scanner;
import heapds.Heap;
public class HeapCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of heap: ");
        int capacity = sc.nextInt();
        Heap heap = new Heap(capacity,1);
        int choice,flag;
        while(true) {
            System.out.println("Select an option:\n1.Insert\n2.Delete\n3.Print\n4.Construct\n5.Sort\n6.Destroy");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the element to be inserted: ");
                    int element = sc.nextInt();
                    heap.insert(element);
                    System.out.print("Heap: ");
                    heap.printHeap();
                    break;
                case 2:
                    System.out.println(heap.deleteMax());
                    System.out.print("Heap: ");
                    heap.printHeap();
                    break;
                case 3:
                    System.out.print("Heap: ");
                    heap.printHeap();
                    break;
                case 4:
                    System.out.print("Enter no. of elements to be inserted: ");
                    int n = sc.nextInt();
                    System.out.print("Enter the elements: ");
                    for(int i=0;i<n;i++) {
                        element = sc.nextInt();
                        heap.insert(element);
                    }
                    System.out.println("Constructed Heap: ");
                    heap.printHeap();
                    break;
                case 5:
                    System.out.print("Enter no. of elements to be sorted: ");
                    n = sc.nextInt();
                    int[] A = new int[n];
                    System.out.print("Enter the elements: ");
                    for(int i=0;i<n;i++) {
                        A[i] = sc.nextInt();
                        heap.insert(A[i]);
                    }
                    System.out.println("Heap: ");
                    heap.printHeap();
                    heap.heapSort(A,n);
                    System.out.print("Sorted Array: ");
                    heap.printHeap();
                    break;
                case 6:
                    heap.destroyHeap();
                    System.out.println("Heap Destroyed");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.print("Do you want to continue?(1/0): ");
            flag = sc.nextInt();
            if(flag==0) {
                break;
            }
        }
        sc.close();
    }
}
