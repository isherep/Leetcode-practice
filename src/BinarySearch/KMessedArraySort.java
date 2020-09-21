package BinarySearch;

import java.util.PriorityQueue;

/*
    K-Messed Array Sort
    Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

    Analyze the time and space complexities of your solution.

    Example:

    input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

    output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    Constraints:

    [time limit] 5000ms

    [input] array.integer arr

    1 ≤ arr.length ≤ 100
    [input] integer k

    0 ≤ k ≤ 20
    [output] array.integer


    function insertionSort(arr):
    for i from 1 to arr.length-1:
        x = arr[i]
        j = i-1

        while (j >= 0 AND arr[j] > x):
            arr[j+1] = arr[j]
            j--
        arr[j+1] = x

    return arr
 */
public class KMessedArraySort {

    static int[] sortKMessedArray(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k > arr.length) return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int exploreIdx = i;
                k = 2;
                while (i >= 0 && k > 1 && arr[exploreIdx] > arr[i + 1]) {
                    k--;
                    exploreIdx--;
                }
                swap(arr, i + 1, exploreIdx);
                // if(exploreIdx != i) i = exploreIdx;
                //i = exploreIdx+1;
            }
        }
        return arr;
    }

    static int[] sortInsert(int[] arr, int k) {

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int prevIdx = i - 1;
            while (prevIdx >= 0 && arr[prevIdx] > cur) {
                arr[prevIdx + 1] = arr[prevIdx];
                prevIdx--;
            }
            arr[prevIdx + 1] = cur;
        }
        return arr;
    }

    /*
        Time Complexity: building a heap takes O(K) time for K+1 elements.
        Insertion into and extraction from the min-heap take O(log(K)), each.
        Across all three loops, we do at least one of these actions N times, so the total time
        complexity is O(N⋅log(K)). if K is substantially smaller than N,
        then we can consider log(K) constant and argue that the complexity is practically linear.

        Space Complexity: we need to a maintain min-heap of size K+1 throughout
        the algorithm, so the auxiliary space complexity is O(K).
     */
    public static int[] sortWithHeap(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            heap.offer(arr[k]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            arr[i - (k + 1)] = heap.poll();
            heap.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            // size of the heap left to the end
            int insertPos = arr.length - k - 1;
            arr[insertPos + i] = heap.poll();
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println('\n');
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] res = sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2);
        printArr(res);

        int[] res1 = sortInsert(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2);
        printArr(res1);

    }

}
