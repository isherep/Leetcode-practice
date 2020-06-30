package BinarySearch;

public class PowerOfX {
    /**
     * -2147483648 is the Integer.MIN_VALUE, while Integer.MAX_VALUE is 2147483647.
     * n*=-1 would cause overflow
     * <p>
     * The reason is if n= -2147483648then -n will be -2147483648.
     * So in 2nd case if (n < 0) return 1.0/pow(x, -n); will be always true and hence it will give you stack overflow error. But in first case power (x,-2147483648) will call power (x,-1073741824) which subsequently will call power(x, -1) which will call power(x,0). And power(x,0) will return 1 then power(x,-1) will return 1 subsequently power(x,-2147483648) will return 1.
     * <p>
     * The reason for -(INT_MIN)=INT_MIN is can be explained as follows:
     * -(INT_MIN)=-(-INT_MAX-1) which will give you -(INT_MIN)=INT_MAX+1.
     * INT_MAX+1 will wrap around and it will give you again INT_MIN
     * <p>
     * Time O(n)
     */
    public double myPow1(double x, int n) {
        if (x == 0.0) {
            return 0;
        }
        if (n == 0.0) {
            return 1;
        }
        if (x == 1.0) {
            return x;
        }
        // corner case 1
        if (n == Integer.MIN_VALUE) {
            if (x == 1.0 || x == -1.0) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        // corner case 2
        if (n == Integer.MAX_VALUE) {
            if (x == 1.0 || x == -1.0) {
                return -1.0;
            } else {
                return 0.0;
            }
        }
        // if the pow == Integer.Max_VALUE || Integer.MIN_VALUE - TLE
        // base multiplier is x if n>0 and is 1/x if n<0 like 2*-2 -> 1/2
        double base = n > 0 ? x : 1 / x;
        if (n > 0) {
            for (long i = 1; i < n; i++) {
                x *= base;
            }
        }
        if (n < 0) {
            n = n * -1;
            for (long i = 1; i < n; i++) {
                base *= (1 / x);
            }
            return base;
        }
        return x;
    }

    /********Leetcode brute force answer*****/
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        for (long i = 0; i < N; i++)
            res = res * x;
        return res;
    }
}

/*********FAST METHOD**********/
    /*The method is based on the observation that, for a positive integer n, we have

        x^n = { x ( x 2 )^ (n − 1)/ 2 -- if  n  is odd
        (x^2 )^n/2 -- if  n  is even .
        This method uses the bits of the exponent to determine which powers are computed.
        else if n is even  then return exp_by_squaring(x * x,  n / 2);
         else if n is odd  then return x * exp_by_squaring(x * x, (n - 1) / 2);

     */

 public static double func_power(int x, int n){
     long N = n;
     if (N < 0) {
         x = 1 / x;
         N = -N;
     }
     double pow = 1;
     double current_product = x;
     for (long i = N; i > 0; i /= 2) {
         if ((i % 2) == 1) {
             pow = pow * current_product;
         }
         current_product = current_product * current_product;
     }
     return pow;
 }
}
