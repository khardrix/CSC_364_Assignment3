import java.util.NoSuchElementException;

public class InPlaceIntHeapSort {



    public static void main(String[] args) {
        // int array to test the heapSort(int[] list){...} method with
        int[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        int[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; // additional int array to test with
        int[] list3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // additional int array to test with
        int[] list4 = {-1, 0, 1}; // additional int array to test with
        // additional int array to test with
        int[] list5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        int[] list6 = {-10_000, 300, 0b100110, 0xFF, 010, (int)1.23e3, (int)'A'}; // additional int array to test with

        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }



/*
    Pseudocode for In-Place Heap Sort

    heapSort(array): // Sorts array in-place
        Let n be the length of the array

        // Part I: Turn the array into a max-heap
        for (i = 1 to n - 1)
            Compare parent_of_i and "Sift up" item at index i

        // Part II: Repeatedly extract the max element at 0-th position from heap
        for (i = n – 1 down to 1)
            // Move the largest item from 0-th to the end i-th index
            swap array[0] with array[i]
            // Note: The last index into the heap is now i – 1
            Compare r/l-child and "Sift down" element at index 0
*/

    public static void heapSort(int[] list){
        int n = list.length; // The number of elements in the passed-in int Array, list
        // int lastIndex = list.size() - 1; // <-- The index of the last node
        // int parentIndex = (currentIndex - 1) / 2; // <-- The index of the parent Node
        // int leftChild = (parentIndex * 2) + 1;
        // int rightChild = (parentIndex * 2) + 2;
        // Part I: Turn the array into a max-heap
        /* for (i = 1 to n - 1)
               Compare parent_of_i and "Sift up" item at index i */
        for(int i = 1; i <= (n - 1); i++){
            if(list[i] > list[(i - 1) / 2]){
                int temp = list[(i - 1) / 2];
                list[(i - 1) / 2] = list[i];
                list[i] = temp;
                i = ((i - 1) / 2) - 1; // since i will be incremented, decrement parent index by 1
            }
        }

        /*
        // Part II: Repeatedly extract the max element at 0-th position from heap
        for (i = n – 1 down to 1)
            // Move the largest item from 0-th to the end i-th index
            swap array[0] with array[i]
            // Note: The last index into the heap is now i – 1
            Compare r/l-child and "Sift down" element at index 0
         */

        for(int i = (n - 1); i >= 1; i--){
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            if(list[1] > list[2]){
                temp = list[0];
                list[0] = list[1];
                list[1] = temp;
            } else{
                temp = list[0];
                list[0] = list[2];
                list[2] = temp;
            }

            /*
            if(list[0] < list[i]) {
                int temp = list[0];
                list[0] = list[i];
                list[i] = temp;
            }
            if(i == 1){
                if(list[i] < list[i + 1]){

                }
            }
            */
        }

    }



/** Heap sort method */
/*
public static <E extends Comparable<E>> void heapSort(E[] list) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<E>();

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
        heap.add(list[i]);

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
        list[i] = heap.remove();
}
*/

/*
for(int i = (n - 1); i >= 1; i--){
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            if(list[1] >= list[2] && list[1] > list[0]){
                temp = list[0];
                list[0] = list[1];
                list[1] = temp;
            }

            /*
            if(list[0] < list[i]) {
                int temp = list[0];
                list[0] = list[i];
                list[i] = temp;
            }
            if(i == 1){
                if(list[i] < list[i + 1]){

                }
            }
            */
/*
}
 */

private void siftUp(int[] list) {
    int k = list.length - 1;

    while(k > 0) {
        int p = (k - 1) / 2;

        int child = list[k];
        int parent = list[p];

        if (child > parent) {
            //swap
            list[k] = parent;
            list[p] = child;

            //adjust k
            k = p;
        } else {
            break;
        }
    }

}


    private void siftDown(int[] list) {
        int k = 0;
        int left = 1;

        while(left < list.length) {
            int max = left;
            int right = left + 1;
            if(right < list.length) {
                if(list[right] > list[left]) {
                    max = right;
                }
            }
            int parent = list[k];
            int child = list[max];

            if(parent < child) {
                //swap
                list[k] = child;
                list[max] = parent;

                k = max;
                left = ((2 * k) + 1);
            }
            else {
                break;
            }
        }
    }


/*
public void insert(T item) {
    items.add(item);
    siftUp();
}

    private void siftUp() {
        int k = items.size() - 1;

        while(k > 0) {
            int p = (k - 1) / 2;

            T child = items.get(k);
            T parent = items.get(p);

            if (child.compareTo(parent) > 0) {
                //swap
                items.set(k, parent);
                items.set(p, child);

                //adjust k
                k = p;
            } else {
                break;
            }
        }

    }

    private void siftDown() {
        int k = 0;
        int left = 1;

        while(left < items.size()) {
            int max = left;
            int right = left + 1;
            if(right < items.size()) {
                if(items.get(right).compareTo(items.get(left)) > 0) {
                    max = right;
                }
            }
            T parent = items.get(k);
            T child = items.get(max);

            if(parent.compareTo(child) < 0) {
                //swap
                items.set(k, child);
                items.set(max, parent);

                k = max;
                left = 2*k+1;
            }
            else {
                break;
            }
        }
    }

    public T remove() throws NoSuchElementException {
        if(items.size() == 0) {
            throw new NoSuchElementException();
        }
        else if (items.size() == 1) {
            return items.remove(0);
        }

        T tmp = items.get(0);
        items.set(0, items.remove(items.size()-1));
        siftDown();
        return tmp;
    }

}
*/
}
