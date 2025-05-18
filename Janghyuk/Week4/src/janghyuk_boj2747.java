import java.io.*;
import java.util.*;

public class Main {
    static int [] d = new int [46];

    public static int fibo(int n)
    {
        if (d[n] != -1)
            return d[n];

        if (n < 2)
        {
            return n;
        }

        d[n] = fibo(n-1) + fibo(n-2);
        return d[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Arrays.fill(d, -1);
        int ans = fibo(n);
        System.out.println(ans);
    }
}