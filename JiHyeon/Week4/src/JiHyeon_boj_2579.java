// 문제 : 백준 2579
// 태그 : DP

// 계단을 밟으면 점수를 얻는다.
// 한번에 한 계단 or 두 계단
// 연속된 세 개의 계단을 모두 밟으면 안된다.
// 얻을 수 있는 총 점수의 최대값을 출력

import java.util.Scanner;
public class JiHyeon_boj_2579 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] scores = new int[N];
        for(int i=0; i<N; i++){
            scores[i] = scanner.nextInt();
        }

        // 계단이 1개만 있는 경우
        if (N == 1) {
            System.out.println(scores[0]);
            return;
        }

        // 계단이 2개만 있는 경우
        if (N == 2) {
            System.out.println(scores[0] + scores[1]);
            return;
        }

        int[] dp = new int[N];
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        System.out.println(dp[N - 1]);
    }
}
