/**********************************************************************************************************************
 **********************************************************************************************************************
 *****     Course: CSC-364-002      Semester: Fall 2019      Professor: Rasib Khan      Student: Ryan Huffman     *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                      Programming Assignment #3: In-place int Heap Sorting Algorithm                        *****
 *****____________________________________________________________________________________________________________*****
 *****               The goal of this assignment is to write an in-place int heap sorting algorithm               *****
 **********************************************************************************************************************
 *********************************************************************************************************************/


public class InPlaceIntHeapSort {


    /** main(String[] args){...} method to test this class's heapSort(int[] list){...} method */
    public static void main(String[] args) {
        // int array to test the heapSort(int[] list){...} method with
        int[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

        heapSort(list); // call the heapSort(int[] list){...} method to sort the array

        // print the array
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }


    /** In-place version of the heapSort(int[] list) {...} method */
    public static void heapSort(int[] list){
        int n = list.length - 1; // The maximum index of the passed in int array, list

        // This for loop loop creates a max heap
        for(int i = 1; i <= (n); i++){
            // if statement to check if the node at index "i" is greater than its parent
            if(list[i] > list[(i - 1) / 2]){
                int temp = list[(i - 1) / 2]; // create an int variable, temp, to store the value of the parent node
                list[(i - 1) / 2] = list[i]; // set the parent node equal to the child node
                list[i] = temp; // set the child node equal to the parent node

                // set index i equal to the parent. Since i will be incremented, decrement parent index by 1
                i = ((i - 1) / 2) - 1;
            }
        }

        // This for loop goes through the max heap, moves the root to the last unsorted index and recreate the max heap
        for(int i = (n); i >= 1; i--){
            int temp = list[0]; // create an in variable, temp, to store the value of the root node
            list[0] = list[i]; // set the value of the root equal to the value of the last unsorted node's value
            list[i] = temp; // set the last unsorted node's value equal to the root

            // This for loop goes through the unsorted heap and makes the heap a max heap again
            for(int j = 0; j <= i; j++){
                // create an int variable, maxIndex, to store the index of the maximum value in the heap
                int maxIndex = j;

                // if statement to check that there is a left child and check if it is greater than its parent
                if((((2 * j) + 1) < i) && (list[(2 * j) + 1] > list[maxIndex])){
                    maxIndex = ((2 * j) + 1); // set the maxIndex equal to the left child
                }
                // if statement to check that there is a right child and check if it is greater than its parent
                if((((2 * j) + 2) < i) && (list[(2 * j) + 2] > list[maxIndex])){
                    maxIndex = ((2 * j) + 2); // set the maxIndex to the right child
                }
                // if statement to check if the maximum value in the array is at the root
                if(maxIndex != j){
                    temp = list[j]; // store the maximum value in the "temp" variable
                    list[j] = list[maxIndex]; // set the value of the current index equal to the maximum value
                    list[maxIndex] = temp; // store the maximum value at the "maxIndex" node
                    // set "j" equal to "maxIndex" and decrement it by 1, since it will be incremented
                    j = (maxIndex - 1);
                }
            }
        }
    }
}
