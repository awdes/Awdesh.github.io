package com.company;

/**
 * Created by awdesh on 10/31/15.
 */
public class CountingSort
{
    public int[] sort(int[] arrayToSort)
    {
        int max = getMaxValue(arrayToSort);
        int[] tempArray = new int[max + 1];

        for(int i = 0; i < arrayToSort.length; i++)
        {
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] + 1;
        }

        for(int i = 1; i < max; i++)
        {
            tempArray[i] = tempArray[i] + tempArray[i-1];
        }

        int[] finalSortedArray = new int[arrayToSort.length];
        for(int i = (arrayToSort.length - 1); i >=0; i--)
        {
            finalSortedArray[tempArray[arrayToSort[i]] - 1] = arrayToSort[i];
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] - 1;
        }

        return finalSortedArray;
    }

    private int getMaxValue(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for(int i : array)
        {
            if(i > max)
            {
               max = i;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        CountingSort countingSort = new CountingSort();
        int[] arrayToSort = new int[] { 0, 3, 1, 0, 5, 2, 4, 5, 2,7,9,10 };
        int[] sortedArray = countingSort.sort(arrayToSort);

        for (int i = 0; i < sortedArray.length; i++)
        {
            System.out.print(sortedArray[i] + ",");
        }
    }
}
