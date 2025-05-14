/*
 * 링크: https://www.acmicpc.net/problem/2609
 * 티어: 브론즈1
 * 날짜: 2025-04-26
 * 태그: 수학, 정수론, 유클리드호제법
 * 문제 요약:
 *   - 두 수의 최대공약수(GCD)와 최소공배수(LCM) 출력
 */

import java.util.*;

public class song_boj_2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        // 최대공약수
        int gcd = getGCD(m, n);
        // 최소공배수
        int lcm = m * n / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}