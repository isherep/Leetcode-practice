package BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInMatrix {

    /********* USING MIN HEAP *********/
        public int kthSmallest(int[][] matrix, int k) {
            if(matrix == null || matrix.length < 1){
                return -1;
            }

            int n = matrix.length;
            PriorityQueue<Node> heap = new PriorityQueue<Node>(Math.min(n, k), new MyHeapComparator());
            for(int i = 0; i< n; i++){
                heap.add(new Node(matrix[i][0], i, 0));
            }
            for(int i = 0; i< k-1; i++){
                Node el = heap.poll();
                System.out.println("el inside while loop " + el.getVal());
                int row = el.getRow();
                int col = el.getCol();

                if( col < n-1){
                    heap.offer(new Node(matrix[row][col+1], row, col+1));
                }
            }
            // System.out.println("el after loop " + heap.peek().getVal());
            return heap.peek().getVal();
        }

        /********* USING BINARY SEARCH **********/
        public int kthSmallestBS(int[][] matrix, int k) {
            int n = matrix.length;
            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int count = getLessEqual(matrix, mid);
                if (count < k) lo = mid + 1;
                else hi = mid - 1;
            }
            return lo;
        }

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
    }

     class Node{
        int row;
        int col;
        int val;

        public Node(int val, int row, int col){
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int getRow(){
            return this.row;
        }
        public int getCol(){
            return this.col;
        }
        public int getVal(){
            return this.val;
        }
    }

    class MyHeapComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2){
            return n1.getVal() - n2.getVal();
        }
    }


