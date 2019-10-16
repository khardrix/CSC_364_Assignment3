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
    public static void heapSort(int list[]){
        int n = list.length - 1; // The maximum index of the passed in int array, list

        /* Part I: Turn the array into a max-heap */
        // This for loop loop creates a max heap
        for(int i = 1; i <= n; i++){
            int currentIndex = i; // store the index of the current element in the heap
            int parent = ((currentIndex - 1) / 2); // store the index of the current index's parent

            // This while loop puts the current element into the correct position in the heap to create a max-heap
            // AKA, this while loop sifts up the current element into its correct position to make a max-heap
            while((list[parent] < list[currentIndex]) && (currentIndex > 0)){
                int temp = list[currentIndex]; // store the value of the current index
                list[currentIndex] = list[parent]; // assign the value of the parent element to the current element
                list[parent] = temp; // assign the value of the child element to the parent element

                currentIndex = parent; // set the current index equal to the index of parent of the current index
                parent = ((currentIndex - 1) / 2); // set the parent index equal to its parent
            }
        }

        /* Part II: Repeatedly extract the max element at 0-th position from heap */
        // This for loop turns the max-heap from the previous for loop into a sorted array
        for(int i = n; i >= 1; i--){
            int temp = list[0]; // create an in variable, temp, to store the value of the root element
            list[0] = list[i]; // set the value of the root equal to the value of the last unsorted element's value
            list[i] = temp; // set the last unsorted element's value equal to the root

            int parentIndex = 0; // store the index of the parent element, which starts as the root
            int leftChild = ((parentIndex * 2) + 1); // store the index of the left child
            int rightChild = ((parentIndex * 2) + 2); // store the index of the right child

            // while loop to make a max heap again
            while(rightChild < i || leftChild < i){

                // if statement to check if the right child index does not exist,
                    // leaving only the right child index to check
                if(rightChild >= i){
                    // if statement to check if the element at the parent index is less than its left child
                    if(list[parentIndex] < list[leftChild]){
                        temp = list[parentIndex]; // store the value of the element in the parent index
                        list[parentIndex] = list[leftChild]; // assign the value of the left child into the parent index
                        list[leftChild] = temp; // assign the value of the parent to the index of the left child
                        parentIndex = leftChild; // set the value of the parent index equal to the index of the left child
                    }
                    // else statement that executes if the left child element is not bigger than its parent
                    else {
                        break; // exit the while loop
                    }
                }

                // else if statement to check if the left child index does not exist,
                    // leaving only the left child index to check
                else if(leftChild >= i){
                    // if statement to check if the value of the right child index is greater than its parent
                    if(list[parentIndex] < list[rightChild]){
                        temp = list[parentIndex]; // store the value of element at the parent index
                        list[parentIndex] = list[rightChild]; // store the value of the right child in the parent index
                        list[rightChild] = temp; // store the value of the parent index in the right child
                        parentIndex = rightChild; // set the parent index equal to the index of the right child
                    }
                    // else statement that executes if the right child element is not bigger than its parent
                    else {
                        break; // exit the while loop
                    }
                }

                // else statement that executes if the current element has two children
                else {
                    int largestChild; // create an int variable to store the index of the child with the largest value

                    // if statement that checks if the left child is bigger than or equal to the right child
                    if(list[leftChild] >= list[rightChild]){
                        // set the value of the largest child index equal to the index of the left child
                        largestChild = leftChild;
                    }
                    // else statement that executes if the value of the right child is bigger than the left child
                    else{
                        // set the value of the largest child index equal to the index of the right child
                        largestChild = rightChild;
                    }

                    // if statement that checks if the largest child is bigger than the children's parent
                    if(list[largestChild] > list[parentIndex]){
                        temp = list[parentIndex]; // store the value of the parent element
                        list[parentIndex] = list[largestChild]; // set the value of the largest child to the parent
                        list[largestChild] = temp; // set the parent value to the largest child's index
                        parentIndex = largestChild; // set the parent index equal to the index of the largest child
                    }

                    // else statement that executes if the largest child is not bigger than its parent
                    else {
                        break; // exit the while loop
                    }
                }
                leftChild = ((parentIndex * 2) + 1); // set the value of the left child's index
                rightChild = ((parentIndex * 2) + 2); // set the value of the right child's index
            }
        }
    }
}
