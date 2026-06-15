package HeapImplementation;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {
    ArrayList<T> list = new ArrayList<>();

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChild(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index, parent);
            heapifyUp(parent);

        }
    }

    private void heapifyDown(int index) {
        int min = index;
        int left = leftChild(index);
        int right = rightChild(index);
        if (left < list.size() && list.get(left).compareTo(list.get(min)) < 0) {
            min = left;

        }
        if (right < list.size() && list.get(right).compareTo(list.get(min)) < 0) {
            min = right;

        }
        if (min != index) {
            swap(min, index);
            heapifyDown(min);
        }
    }

    public void insert(T value) {
        list.add(value);
        heapifyUp(list.size() - 1);

    }

    public T delete() {
        if (list.isEmpty()) {
            return null;
        }
        T removed=list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        heapifyDown(0);
        return removed;

    }
    public T peek() {
    if (list.isEmpty()) {
        return null;
    }
    return list.get(0);
}
public static void main(String[] args) {
    HeapGeneric<Integer> heap = new HeapGeneric<>();

heap.insert(5);
heap.insert(2);
heap.insert(8);
heap.insert(1);

System.out.println(heap.delete()); // 1
System.out.println(heap.delete()); // 2
System.out.println(heap.delete()); // 5
System.out.println(heap.delete()); // 8
}

}
