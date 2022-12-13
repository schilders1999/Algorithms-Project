/**
 * QuickSort organizes a randomly generated array composed of unique integers. Pulled from www.programiz.com
 *  
 * 
 */

public class QuickSort {


    //QuickSort algorithm sorting random, unique, unordered array of n values. Implementing code from www.programiz.com.
        
    static long sortcounter = 0; //counter for operations
    
    static int partition(int arrayA[], int low, int high){

        
        //rightmost element in array is assigned to pivot value
        int pivot = arrayA[high];
        
        
        //pointer for element of higher numeric value
        int i = (low-1);

        //traversing through array, comparing each element with value of pivot
        for (int j = low; j < high ; j++){
            if (arrayA[j] <= pivot){
                i++;
                //Swapping pointer values
                int temp = arrayA[i];
                arrayA[i] = arrayA[j];
                arrayA[j] = temp;
                sortcounter++;
            }

        }

        //Swapping the pivot value with the value that both pointers are located at
        int temp = arrayA[i+1];
        arrayA[i+1] = arrayA[high];
        arrayA[high] = temp;
        sortcounter++;

        //returns the low value for the right partition
        return (i+1);
    }

    static void quickSort(int arrayA[], int low, int high){
        if (low<high) {
            
            int pi = partition(arrayA, low, high);
            


            //Sorting of lower partition
            quickSort(arrayA, low, pi - 1);

            //Sorting of higher partition
            quickSort(arrayA, pi+1, high);
        }
    }
    
}


