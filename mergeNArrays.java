package com.company;

import java.util.PriorityQueue;

/**
 * Created by AS025782 on 8/5/2015.
 */
public class mergeNArrays
{
    public static int[] mergeArrays(int[][] sortedArrays)
    {
        int totalLength = 0;
        PriorityQueue<ArrayContainer> heap = new PriorityQueue<ArrayContainer>();

        for(int i = 0; i <sortedArrays.length; i++)
        {
            totalLength+= sortedArrays[i].length;
            heap.add(new ArrayContainer(sortedArrays[i]));
        }
        int[]result=new int[totalLength];
        int index=0;
        while(!heap.isEmpty())
        {
            ArrayContainer arrayContainer=heap.poll();
            result[index++]=arrayContainer.getNextInt();
            if (arrayContainer.isEmpty())
                continue;
            heap.add(arrayContainer);
        }
        return result;
    }

    private static class ArrayContainer implements Comparable < ArrayContainer > {
        private int startIndex;
        private int[] array;

        public ArrayContainer(int[] array) {
            this.array = array;
            startIndex = 0;
        }

        public boolean isEmpty() {
            return startIndex == array.length;
        }

        public int peek() {
            return array[startIndex];
        }

        public int getNextInt() {
            return array[startIndex++];
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return new Integer(peek()).compareTo(o.peek());
        }
    }
}
