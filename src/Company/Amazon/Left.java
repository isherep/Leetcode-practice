package Company.Amazon;

public class Left {
    public static void rotateLeftByD(int[] arr, int d, int n) {
        // find whre d is in the array
        // create a new array
        int[] res = new int[n];
        if (arr == null || n < 0 || d < 0) return;
        // find where d is in the array
        int dIdx = 0;
        while (dIdx < d) {
            dIdx++;
        }
        int newStart = dIdx + 1;
        int j = 0;
        for (int i = dIdx; i < n; i++) {
            res[j] = arr[i];
            j++;
        }

        for (int i = 0; i < dIdx; i++) {
            res[j] = arr[i];
            j++;
        }

        for (int k = 0; k < res.length; k++) {
            System.out.print(res[k] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        int d = 4;

        int[] a = {1, 2, 3, 4, 5};

        rotateLeftByD(a, d, n);

    }

}
