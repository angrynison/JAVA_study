/*
 * 링크: https://www.acmicpc.net/problem/1929
 * 티어: 실버 Ⅲ
 * 키워드: 에라토스테네스의 체
 * 문제 요약:
 *   - M 이상 N 이하의 모든 소수를 오름차순으로 출력
 */

import java.util.*;

public class song_boj_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[n + 1];  // 인덱스가 숫자를 의미하도록 배열 크기를 n + 1
        Arrays.fill(isPrime, true);  // 모두 소수라고 가정

        isPrime[0] = false;  // 0 제외
        isPrime[1] = false;  // 1 제외

        // 에라토스테네스의 체:
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // i의 배수는 소수가 아님
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 결과 출력
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
