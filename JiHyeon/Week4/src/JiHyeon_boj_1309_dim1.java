
// 문제 : 백준 1309
// 태그 : DP

// 2 x N 배열에 사자를 배치하는 경우의 수
// 가로로 붙이기 불가, 세로로 붙이기 불가 => 대각선으로만 가능
// 한마리도 배치하지 않는 경우도 1가지 경우의 수

// 우리의 크기를 입력 받아서
// 첫째 줄에 사자를 배치하는 경우의 수를
// 9901로 나눈 나머지

import java.util.Scanner;
public class JiHyeon_boj_1309_dim1 {
    public static void main(String[] args) {

        // 행 단위로 반복적인 패턴을 가진다.
        // dp[i] = 이전 줄에서 가능한 경우들로부터 이어지는 방법 수

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int MOD = 9901;

        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 3;

        for(int i=2; i<=N; i++){
            // dp[i-1]*2 + dp[i-2]

            // i번째 줄에서 사자를 한마리만 놓는 경우
            // 전 줄이 0-0, 1-0, 0-1 이면, 새 줄에 1-0 또는 0-1 중에 하나를 붙인다.
            // dp[i-1]의 각 경우에 2가지 선택지

            // i번쨰 줄에 사자를 안놓는 경우
            // i-1와 i 번째를 모두 0으로 둔다.
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}
