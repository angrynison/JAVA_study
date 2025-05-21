import java.util.Scanner;

public class JaeHong_Boj_2748_피보나치_수2 {
    public static void main(String[] args) {
        // 상향식
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(fibo[n]);
    }
}
