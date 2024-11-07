/******************************************************************
 *
 *   Andrew Rowe / COMP 272-002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // Create a new HashSet called "set" that takes integers...
        Set<Integer> set = new HashSet<>();
            // Add integers to list1 to a HashSet...
            for (int num : list1) {
                set.add(num);
                }
            // Each integer in list2, check if exists in the HashSet. If missing return false...
            for (int num : list2) {
                if (!set.contains(num)) {
                     return false;
                }
            }
            // If all integers exist in list2, return true
            return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        // First, initialize a priority queue of size 'k' to store the largest 'k' integer encountered...
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // Iterate through the array[], adding each integer to the priority queue...
        for (int num : array) {
            minHeap.add(num);
            // If the size of the priority queue (minHeap) exceeds 'k'...
            if (minHeap.size() > k) {
                // remove the smallest integer, maintains the top 'k' integers...
                minHeap.poll();
            }
        }
        // returns the k-th largest integer.
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // Create a new array[] called "combined" that takes integers...
        List<Integer> combined = new ArrayList<>();
        // Add integers from array1 and array2 to list "combined"...
            for (int num : array1) {
                combined.add(num);
            }
            for (int num : array2) {
                combined.add(num);
            }
            // Sort the "combined" list and convert it back to int[]
            Collections.sort(combined);
            return combined.stream().mapToInt(Integer::intValue).toArray();
    }
}