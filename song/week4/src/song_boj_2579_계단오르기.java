/*
 * 링크: https://www.acmicpc.net/problem/2579
 * 난이도: 실버 Ⅲ
 * 키워드: 상태 정의 DP
 * 문제 요약:
 *   - 점수를 얻으며 계단을 오를 때 연속 3칸을 밟지 않고 마지막 계단까지 가는 최대 점수
 */
import java.util.*;

public class song_boj_2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] steps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steps[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];  // dp[i] = i번째 계단을 밟았을 때 얻을 수 있는 최대 점수

        // 기저 조건
        dp[0] = 0;
        dp[1] = steps[1];
        if (n >= 2) dp[2] = steps[1] + steps[2];

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                dp[i - 2] + steps[i],                // i - 2를 밟고 i - 1을 안 밟고 i를 밟았을 때
                dp[i - 3] + steps[i - 1] + steps[i]  // i - 2를 안 밟고 i - 1을 밟고 i를 밟았을 때
            );
        }

        System.out.println(dp[n]);
    }
}
