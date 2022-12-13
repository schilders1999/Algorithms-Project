/**
 * Main creates a random, unique, unordered array of size n and then performs quicksort and insertionsort algorithms
 * on array. Displays number of operations and time needed for each to complete. 
 *  
 * @author ~ Spencer Childers 
 */

import java.security.SecureRandom;


public class Main {
    public static void main(String[] args) throws Exception {


        //Generating random, unique, unordered array of n values.
        
        SecureRandom secureRandom = new SecureRandom();

        int randomNum;

        //Index reference for outer while loop
        int i = 0;

        //Number of values in array.
        int n = 100000;

        //Index reference for inner while loop.
        int j;

        //Setting array to have n values
        int [] array = new int [n];

        //Outer while loop that iterates through array with variable i. Fills random values into index i.
        while(i<n){ 

            j = 0;

            //Assigning int randomNum to a random value from 0 to n*10.
            randomNum = secureRandom.nextInt(n*10);

            array[i] = randomNum;

            //Inner while loop that reiterates through array using variable j to check if there are any repeats in the array. 
            while(j<i){

                //If the integer created is a duplicate, a new value is assigned to this index j and then the array is check again for duplicates.
                if(array[j] == array[i]){
                    randomNum = secureRandom.nextInt(n*10);
                    array[i] = randomNum;
                    j = 0;
                }
                else{
                    j++;
                }
            }
            
            i++;
        }

        //Making copy of array so both sorting algorithms get to use same array. 

        int [] copyarray = new int [n]; 
        
        for (i = 0; i < n; i++){
            copyarray[i] = array[i];
        }



        //For loop for printing unordered  array.
        System.out.println("================================================\n\nPrinting Unordered Unique Array of Size: " + n + "\n");
        for(i = 0 ; i < n-1 ; i++){
            System.out.print(array[i] + ",");
        }
        System.out.print(array[n-1] + "\n\n================================================\n\n");


        //Sorting array via quicksort. Adapted from www.programiz.com.    
        long startTime = System.nanoTime();
        QuickSort.quickSort(array, 0, n-1);
        long endTime = System.nanoTime();
        long totalTimeNS = endTime - startTime;
        


        //For loop for printing finished array.
        System.out.println("=-=-QUICKSORT-=-=\n\n\nOrdered array of size " + n + " via quicksort:\n");
        // for(i = 0 ; i < n-1 ; i++){
        //     System.out.print(array[i] + ",");
        // }
        // System.out.print(array[n-1] + "\n\n");

        System.out.println("Number of swaps: " + QuickSort.sortcounter +  "\n\nExecution time in nanoseconds  : " + totalTimeNS + "\n\nExecution time in milliseconds  : " + totalTimeNS/1000000 + "\n\n================================================\n");






        //Sorting array via insertionSort. Adapted from www.javatpoint.com
        startTime = System.nanoTime();
        InsertionSort.insertionSort(copyarray, n);
        endTime = System.nanoTime();
        totalTimeNS = endTime - startTime;

        //For loop for printing finished array.
        System.out.println("=-=-INSERTIONSORT-=-=\n\n\nOrdered array of size " + n + " via insertion sort:\n");
        // for(i = 0 ; i < n-1 ; i++){
        //     System.out.print(copyarray[i] + ",");
        // }
        // System.out.print(copyarray[n-1] + "\n\n");

        System.out.println("Number of swaps: " + InsertionSort.counter + "\n\nExecution time in nanoseconds  : " + totalTimeNS + "\n\nExecution time in milliseconds  : " + totalTimeNS/1000000 + "\n\n================================================\n");
    }
}
