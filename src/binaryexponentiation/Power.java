package binaryexponentiation;

import java.util.Scanner;

public class Power {

    public static void main(String[] args) {
        Power power = new Power();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number: ");
        int a = kb.nextInt();
        System.out.print("Enter power: ");
        int n = kb.nextInt();

        System.out.printf("ITERATIVE : %d power %d = %f%n", a, n, power.powerIterative(a, n));
        System.out.printf("RECURSIVE: %d power %d = %f", a, n, power.powerRecursive(a, n));
    }

    public static double powerRecursive(int a, int n) {
        if (n == 0) return 1;

        double ans = powerRecursive(a, n / 2);
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * a;
        }
    }

    public static double powerIterative(int a, int n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            n >>= 1;
            a *= a;
        }
        return ans;
    }
}
