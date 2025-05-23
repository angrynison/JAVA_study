/*
 * 링크: https://www.acmicpc.net/problem/9095
 * 난이도: 실버 Ⅲ
 * 키워드: 기본 DP
 * 문제 요약:
 *   - 정수 n을 1, 2, 3의 합으로 나타내는 모든 경우의 수 구하기
 */
import java.util.*;

public class song_boj_9095_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] dp = new int[12];  // "n은 양수이며 11보다 작다."
        dp[1] = 1;  // 1 = (1)
        dp[2] = 2;  // 2 = (1+1), (2)
        dp[3] = 4;  // 3 = (1+1+1), (1+2), (2+1), (3)

        // dp[i] = 정수 i를 1, 2, 3의 합으로 표현하는 모든 경우의 수
        // i를 만들기 위한 마지막 숫자가 1이면 dp[i - 1], 2이면 dp[i - 2], 3이면 dp[i - 3]
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
