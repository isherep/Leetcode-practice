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

    /**
     * Better persomamce
     *
     The while loop in line # 10 has an AND (&&) condition so that we compare elements when we have candidates from both the arrays.
     Now, after the last comparison, the following cases can arise:
     Case 1: All the elements of nums2 have been compared and put in their right position because all the initialized elements of num2 were greater than at least one initialized element of num1.
     In this case, the initialized elements of num1 not compared are already in their right position (as the destination is num1 and they were already sorted).
     Case 2: All the elements of nums1 have been compared and put in their right position because all the initialized elements of num1 were greater than at least one initialized element of num2.
     In this case, the initialized elements of nums2 not compared are still in nums2 and not in their destination i.e. nums1. They are sorted and just need to copied over to nums1. That is what line # 16 does using the System.arraycopy method.

     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        // in place version - do not more first part of array
        int i = m-1;
        int j = n-1;
        int ins_idx = nums1.length-1;

        while((i>=0) && (j>=0)){
            // compare and place
            if(nums2[j] > nums1[i]){
                nums1[ins_idx] = nums2[j];
                j--;
            } else {
                nums1[ins_idx] = nums1[i];
                i--;
            }
            ins_idx --;
        }

        // after this the i is -1 and you ended all the first elements, you filled the back
        // of you can iterate and copy all the elements
        //System.arraycopy(nums2, 0, nums1, 0, j + 1);
        while(j>=0){
            nums1[ins_idx--] = nums2[j--];
        }
    }

    public static void main(String[] args){
        for(int i = 0; i<10; i = i++){
        i+=1;
        System.out.print(i);
        }
    }
    //System.out.print()

}
