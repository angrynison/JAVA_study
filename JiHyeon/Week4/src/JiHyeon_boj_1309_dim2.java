// 문제 : 백준 1309
// 태그 : DP

// 2 x N 배열에 사자를 배치하는 경우의 수
// 가로로 붙이기 불가, 세로로 붙이기 불가 => 대각선으로만 가능
// 한마리도 배치하지 않는 경우도 1가지 경우의 수

// 우리의 크기를 입력 받아서
// 첫째 줄에 사자를 배치하는 경우의 수를
// 9901로 나눈 나머지

import java.util.Scanner;

public class JiHyeon_boj_1309_dim2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int MOD = 9901;

        int[][] dp = new int[N+1][3];
        // 한 행에서 할 수 있는 경우에 0,1,2 로 태깅해준다.
        // 0 : 0-0 으로 사자배치 안함
        // 1 : 1-0 으로 왼쪽에 사자 배치
        // 2 : 0-1 으로 오른쪽에 사자 배치
        // dp[i번째 행][행동 태그값]
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // 이전 i+1이 1-0
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD; // 이전 i+1이 0-1
        }
        System.out.println(dp[N][0]+ dp[N][1] + dp[N][2]);

    }
}
