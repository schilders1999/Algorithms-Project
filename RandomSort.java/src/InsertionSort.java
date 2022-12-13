/**
 * InsertionSort organizes a randomly generated array composed of unique integers.
 *  
 * @author ~ Spencer Childers 
 */


public class InsertionSort {

    static long counter = 0; //counter for operations 
    static void insertionSort(int arrayA[], int n){

       
        //InsertionSort algorithm sorting random, unique, unordered array of n values. Pulled from www.javatpoint.com.
        int i;
        int j;

        for (i = 1; i < n; i++) {  
            int key = arrayA[i];  

            j = i-1;  

            while ( (j > -1) && ( arrayA[j] > key ) ) {  
                arrayA[j+1] = arrayA[j];  
                counter++;
                j--;  
            }  
            arrayA[j+1] = key;  

        }  
    }   
}
