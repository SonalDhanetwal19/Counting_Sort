package dsa;

import java.util.Arrays;

public class Counting_Sort_OrderN {
    public static void main(String[] args)
    {
        int[] input = {14,5,8,14,5,6,5,8,9,16,13,16,5};
        int size = input.length;
        countingSort(input,size);
        System.out.println(Arrays.toString(input));
    }

    static void countingSort(int[] input,int size)
    {
        //size+1 is taken to create an index
        int[] output = new int[size+1];
        int max = 0;
        //pick the max number from the input array to create auxillary
        //array of size= max to store the count of each number
        for(int i = 0;i < size;i++)
        {
            if(input[i]>max)
            {
                max=input[i];
            }
        }
        //initialize auxillary array to 0
        int[] count = new int[max+1];
        for(int i = 0; i <= max; i++)
        {
            count[i]=0;
        }

        // increment the count for each occurrence values from the input array
        for(int i = 0;i<size;i++)
        {
            count[input[i]]++;
        }

        // perform cumulative addition for each for all the counters
        for(int i =1; i<=max;i++)
        {
            count[i]+=count[i-1];
        }

        // Now starting from the end of the input array start populating the values in the output array
        //at position calculated by the auxillary array.
        //Also, start decrementing the count for specific index in auxiallary array(count[])
        for(int i = size-1;i>=0;i--)
        {
            output[count[input[i]]-1]=input[i];
            count[input[i]]--;
        }

        //copy the output array to input array
        for(int i = 0; i< size; i++)
        {
            input[i]=output[i];
        }

    }
}