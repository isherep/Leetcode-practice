package Company.Amazon;

public class HighestCommonFactor {

    public static int highestDivisor(int m, int n) {

        while (m != n) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        return m;
    }

    // recursive
    // Recursive function to return gcd of a and b
    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }


    // more efficient recursive
    // Recursive function to return gcd of a and b
    static int gcde(int a, int b) {
        if (b == 0)
            return a;
        return gcde(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(highestDivisor(70, 15)); //5
        System.out.println(highestDivisor(98, 56)); //14
        System.out.println(highestDivisor(98, 56));

    }
}
