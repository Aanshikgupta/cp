package binaryexponentiation;

import java.util.Scanner;

public class NthFibonacci {

    public static void main(String[] args) {
        System.out.print("Program to get nth fibonacci, Enter n : ");
        int n = new Scanner(System.in).nextInt();
        System.out.println(getNthFibonacciNaive(n));//O(n)-O(1)
        System.out.println(getNthFibonacciRecursive(n));//O(n)-O(n)
        System.out.println(getNthFibonacciOptimized(n));//O(log(n))-O(1)
    }

    private static int getNthFibonacciOptimized(int n) {
        int[][] A = {{1, 1}, {1, 0}};
        int[][] result = Matrix.power(A, n - 1);
        return result[1][0] + result[1][1];
    }

    private static int getNthFibonacciNaive(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int first = 1, second = 1, ans = 0;
        for (int i = 1; i <= n - 2; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
    }

    private static int getNthFibonacciRecursive(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        return getNthFibonacciRecursive(n - 1) + getNthFibonacciRecursive(n - 2);
    }
}
