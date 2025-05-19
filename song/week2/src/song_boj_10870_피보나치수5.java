/*
 * 링크: https://www.acmicpc.net/problem/10870
 * 난이도: 브론즈 Ⅱ
 * 키워드: 재귀
 * 문제 요약:
 *   - 피보나치 수열
 *   - F(n) = F(n-1) + F(n-2)
 */
import java.util.*;

public class song_boj_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
}
