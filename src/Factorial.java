import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(BigInteger[] arr, int lo, int hi) {
        if (hi - lo == 1) return arr[lo];
        int mid = lo + (hi - lo) / 2;
        return factorial(arr, lo, mid).multiply(factorial(arr, mid, hi));
    }

    public static double timeTrial(int n) {
        Stopwatch s = new Stopwatch();
        //function to test below
        BigInteger[] arr = new BigInteger[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = new BigInteger(i + "");
        }
        factorial(arr, 0, arr.length);
        return s.elapsedTime();
    }

    public static BigInteger[] getBigIntegerArr(int n) {
        BigInteger[] ret = new BigInteger[n];
        for (int i = 1; i <= n; i++)
            ret[i - 1] = new BigInteger(i + "");
        return ret;
    }

    public static int findConsecutive(BigInteger num, String numToFind) {
        String s = num + "";
        char[] arr = s.toCharArray();
        int currentMax = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '9')
                currentMax++;
            else {
                if (currentMax > max)
                    max = currentMax;
                currentMax = 0;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        BigInteger[] arr = getBigIntegerArr(1000000);
        BigInteger num = factorial(arr, 0, arr.length);
        StdOut.println(findConsecutive(num, "9"));
//        StdOut.println(num);
    }
}