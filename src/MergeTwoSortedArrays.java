public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        // check if after iteration there are still n left
        while (j < n) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        while (i < m) {
            res[k] = nums1[i];
            i++;
            k++;
        }

        for (int it1 = 0; it1 < res.length; it1++) {
            nums1[it1] = res[it1];
        }

        for (int it = 0; it < res.length; it++) {
            System.out.print(res[it] + ", ");
        }
    }
}
