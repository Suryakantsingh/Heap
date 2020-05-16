package heap;

public class MaxHeap {
    private int maxSize;
    private int size;
    private static final int FRONT = 1;
    private int[] heap;


    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public int parent(int pos) {
        return (pos / 2);
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

    public void swap(int fpos, int lpos) {

        int temp = heap[fpos];
        heap[fpos] = heap[lpos];
        heap[lpos] = temp;
    }

    public void insert(int key) {

        if (size >= maxSize)
            return;

        heap[++size] = key;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= (size / 2); i++) {
            System.out.print("Parent : " + heap[i]
                    + " leftChild :" + heap[2 * i]
                    + " rightChild " + heap[(2 * i) + 1]);
            System.out.println();
        }
    }

    public void heapify(int pos) {

        if (!isLeaf(pos)) {

            if( heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]){

                if(heap[leftChild(pos)] > heap[rightChild(pos)]){
                    swap(pos,leftChild(pos));
                    heapify(leftChild(pos));
                }else{
                    swap(pos,rightChild(pos));
                    heapify(rightChild(pos));
                }
            }

        }
    }

    public int extractMax(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);
        return popped;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();

        maxHeap.extractMax();
        maxHeap.print();


    }
}
