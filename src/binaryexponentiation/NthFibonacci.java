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
        int[][] result = power(A, n - 1);
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

    private static int[][] power(int[][] A, int n) {
        if (n == 0) {
            return identityMatrix(A);
        }

        int[][] X = powerIterative(A, n / 2);

        if (n % 2 == 0) {
            return mul(X, X);
        } else {
            return mul(X, mul(X, A));
        }

    }

    private static int[][] powerIterative(int[][] A, int n) {
        int[][] result = identityMatrix(A);
        while (n > 0) {
            if ((n & 1) == 1) {
                result = mul(result, A);
            }
            n >>= 1;
            A = mul(A, A);
        }
        return result;
    }

    private static int[][] identityMatrix(int[][] a) {
        int r = a.length, c = a[0].length;
        int[][] identity = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    identity[i][j] = 1;
                }
            }
        }
        return identity;
    }

    private static int[][] mul(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;

        if (c1 != r2) {
            throw new RuntimeException(String.format("Matrix multiplication is not possible for these matrics as C1[%d] != R2[%d]", c1, r2));
        }

        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }

    private static void printMat(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
