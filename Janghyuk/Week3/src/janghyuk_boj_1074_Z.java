import java.util.*;
import java.io.*;

public class Main {
    public static int func(int n, int r, int c) {
        if (n == 0) return 0;

        int half = (int)Math.pow(2, n - 1); // 2^n 의 절반

        if (r < half && c < half) {
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        } else {
            return 3 * half * half + func(n - 1, r - half, c - half);
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(func(n, r, c));
    }

}


