public class InPlaceIntHeapSort {



    public static void main(String[] args) {
        // int array to test the heapSort(int[] list){...} method with
        int[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        int[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; // additional int array to test with
        int[] list3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // additional int array to test with
        int[] list4 = {-1, 0, 1}; // additional int array to test with
        // additional int array to test with
        int[] list5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        int[] list6 = {-10_000, 300, 0b100110, 0xFF, 010, (int)1.23e3}; // additional int array to test with
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
    }
}
