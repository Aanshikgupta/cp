package binaryexponentiation.practice;

import java.io.*;

public class MatrixExponentiation {

    static final long MOD = 1_000_000_007L;

    static long getNthFib(long n) {
        if (n == 0) return 0;
        long[][] A = {{1, 1}, {1, 0}};
        long[][] result = power(A, n - 1);
        return (result[1][0] % MOD + result[1][1] % MOD) % MOD;
    }

    static long[][] getIdentityMatrix(int n) {
        long[][] identity = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identity[i][j] = 1;
                }
            }
        }
        return identity;
    }

    static long[][] power(long[][] A, long n) {
        if (n == 0) {
            return getIdentityMatrix(A.length);
        }

        long[][] X = power(A, n / 2);

        if (n % 2 == 0) {
            return mul(X, X);
        } else {
            return mul(X, mul(X, A));
        }

    }


    static long[][] mul(long[][] mat1, long[][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;

        if (c1 != r2) {
            throw new RuntimeException(String.format("Matrix multiplication is not possible for these matrics as C1[%d] != R2[%d]", c1, r2));
        }

        long[][] result = new long[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] = (result[i][j] + ((mat1[i][k] * mat2[k][j]) % MOD)) % MOD;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder output = new StringBuilder();
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        output.append(getNthFib(n)).append('\n');
        System.out.print(output);
    }
}