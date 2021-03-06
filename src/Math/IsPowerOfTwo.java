package Math;

public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        while (n >= 1) {
            // intermediate res has to div by two unless it's
            if (n % 2 != 0 && n != 1) {
                return false;
            }
            if (n == 1) return true;
            n = n / 2;
        }
        return false;
    }

    public static boolean isPower(int n){
        if (n <= 0) return false;
        while (n%2 == 0) n/=2;
        return n == 1;
    }

    public static void main(String[] args) {
        //int n = 128;
        System.out.println(isPowerOfTwo(218));
    }
}
