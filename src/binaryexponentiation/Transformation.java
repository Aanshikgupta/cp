package binaryexponentiation;

import java.util.Scanner;

//Perform X,Y -> X+Y,2Y-X N times
public class Transformation {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Program to get nth recurrence for (X,Y)->(X+Y, 2Y-X), Enter n : ");
        int n = kb.nextInt();
        System.out.print("Enter X: ");
        int x = kb.nextInt();
        System.out.print("Enter Y: ");
        int y = kb.nextInt();

        int[][] result = getRecurrence(x, y, n);//O(log(n))-O(1)
        Matrix.printMat(result);
    }

    private static int[][] getRecurrence(int x, int y, int n) {
        int[][] base = {{x}, {y}};
        int[][] transformationMatrix = {{1, 1}, {-1, 2}};
        return Matrix.mul(Matrix.powerIterative(transformationMatrix, n), base);
    }
}
