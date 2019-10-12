// HeapSort class from Y. Daniel Liang's "Introduction to Java Programming"

import java.util.Arrays;

public class HeapSort {
    /** Heap sort method */
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

    /** A test method */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");



        //////////// ALL CODE FROM HERE DOWN ADDED BY ME!!!!!!! ////////////
        System.out.println("\n\nFor each loop printout of the int Array:");
        for(Integer x : list)
            System.out.print(x + " ");

        System.out.println("\n\nArrays.toString(list) printout of the int Array:");
        System.out.println(Arrays.toString(list));
    }
}