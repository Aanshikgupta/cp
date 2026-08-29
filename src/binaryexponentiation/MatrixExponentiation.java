package binaryexponentiation;

public class MatrixExponentiation {

    public static void main(String[] args) {
        int[][] mat1 = {{1, 2}, {3, 4}};
        int power = 2;
        int[][] result = power(mat1, power);
        printMat(result);
    }

    private static int[][] power(int[][] A, int n){
        if (n == 0) {
            return identityMatrix(A);
        }

        int[][] X = power(A,n/2);

        if(n%2==0){
            return mul(X,X);
        } else {
            return mul(X,mul(X,A));
        }

    }

    private static int[][] identityMatrix(int[][] a) {
        int r=a.length,c=a[0].length;
        int[][] identity = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==j){
                    identity[i][j]=1;
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
