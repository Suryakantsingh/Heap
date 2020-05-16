package heap;

public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;

    }

    //give the position of Parent Node

    public int parent(int pos) {
        return pos / 2;

    }

    public int leftChild(int pos) {
        return (2 * pos);
    }

    public int rightChild(int pos) {
        return ((2 * pos) + 1);
    }

    public boolean isLeaf(int pos) {

        if (pos >= (size / 2) && pos <= size) {
            return true;
        }

        return false;
    }

    public void swap(int fpos, int spos) {
        int temp = 0;
        temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    public void insert(int key) {

        if (size >= maxSize)
            return;

        Heap[++size] = key;
        int current = size;

        while (Heap[current] <= Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minHeapify(int pos) {

        if (!isLeaf(pos)) {

            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }

            }
        }

    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public void print() {

        for (int i = 1; i <= size / 2; i++) {

            System.out.print("Parent : " + Heap[i]
                    + " Left Child : " + Heap[2 * i]
                    + " Right Child : " + Heap[(2 * i) + 1]);

            System.out.println();
        }
    }

    public int remove() {

        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    public static void main(String[] args) {

        System.out.println("This is the Min Heap");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.minHeap();

        minHeap.print();

        System.out.println(minHeap.remove());

        minHeap.print();


    }
}
