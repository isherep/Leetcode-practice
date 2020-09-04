package Array;

/**
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 */
public class MinimumNumberOfJumps {
    // select 1
    // {1, 4, 5}     , 8, 9} , 2, 6, 7, 6, 8, 9}
    // number of ways
    // [1, 4, 5,  ]
    // 8 n- number of ways 3 + number of ways
    public static int minNumJumps(int[] arr){
        int counter = 0;
        int i = 0;
        while( i < arr.length){
            i = i + arr[i];
            counter++;
        }
        return counter;
    }

    public static void main(String[] args){
        System.out.println(minNumJumps(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 1, 1, 1, 1, 1 }));
        System.out.println(minNumJumps(new int[] {1, 3, 5 }));
    }

    }
