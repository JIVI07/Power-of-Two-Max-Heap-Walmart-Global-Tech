import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap<T extends Comparable<T>> {

    private final List<T> heap;
    private final int branchingFactor; // number of children per node (2^x)

 
    public PowerOfTwoMaxHeap(int x) {
        if (x < 0) throw new IllegalArgumentException("x must be non-negative");
        this.branchingFactor = (int) Math.pow(2, x);
        if (branchingFactor < 1) throw new IllegalArgumentException("branchingFactor must be >= 1");
        this.heap = new ArrayList<>();
    }

  
    public void insert(T value) {
        if (value == null) throw new IllegalArgumentException("null values not allowed");
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

   
    public T popMax() {
        if (heap.isEmpty()) return null;
        T max = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

   
    public T peekMax() {
        return heap.isEmpty() ? null : heap.get(0);
    }

   
    public int size() {
        return heap.size();
    }

 
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Move element at index up to restore heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = getParent(index);
            if (parentIndex < 0) break;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Move element at index down to restore heap property
    private void heapifyDown(int index) {
        final int n = heap.size();
        while (true) {
            int maxIndex = index;
            // children numbered 1..branchingFactor
            for (int k = 1; k <= branchingFactor; k++) {
                int childIndex = getChild(index, k);
                if (childIndex < n && heap.get(childIndex).compareTo(heap.get(maxIndex)) > 0) {
                    maxIndex = childIndex;
                }
            }
            if (maxIndex == index) break;
            swap(index, maxIndex);
            index = maxIndex;
        }
    }

    // Parent index calculation
    private int getParent(int index) {
        if (index == 0) return -1;
        return (index - 1) / branchingFactor;
    }

    // k-th child index (k in 1..branchingFactor)
    private int getChild(int index, int k) {
        return branchingFactor * index + k;
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    // For debugging: simple list representation
    @Override
    public String toString() {
        return heap.toString();
    }

    // Simple test/demo main (not the benchmark)
    public static void main(String[] args) {
        PowerOfTwoMaxHeap<Integer> heap = new PowerOfTwoMaxHeap<>(2); // 2^2 = 4 children
        heap.insert(10);
        heap.insert(40);
        heap.insert(30);
        heap.insert(50);
        heap.insert(20);

        System.out.println(heap);                   // print internal list
        System.out.println("Max Element: " + heap.popMax());
        System.out.println(heap);
        System.out.println("Peek Max: " + heap.peekMax());
    }
}
