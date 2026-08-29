package binaryexponentiation;

public class Matrix {

    public static void main(String[] args) {
        //Matrix multiplication
        int[][] mat1 = {{1, 1}, {-1, 2}};
        int[][] mat2 = {{1}, {1}};
        int[][] result = mul(mat1, mat2);
        printMat(result);

        //Matrix to the power N
        int N = 2;
        int[][] result2 = power(mat1, N);
        printMat(result2);
    }

    static int[][] mul(int[][] mat1, int[][] mat2) {
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

    static void printMat(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] getIdentityMatrix(int n) {
        int[][] identity = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identity[i][j] = 1;
                }
            }
        }
        return identity;
    }

    static int[][] power(int[][] A, int n) {
        if (n == 0) {
            return getIdentityMatrix(A.length);
        }

        int[][] X = powerIterative(A, n / 2);

        if (n % 2 == 0) {
            return mul(X, X);
        } else {
            return mul(X, mul(X, A));
        }

    }

    static int[][] powerIterative(int[][] A, int n) {
        int[][] result = getIdentityMatrix(A.length);
        while (n > 0) {
            if ((n & 1) == 1) {
                result = mul(result, A);
            }
            n >>= 1;
            A = mul(A, A);
        }
        return result;
    }
}
