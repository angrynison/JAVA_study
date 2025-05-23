import java.util.Scanner;

public class JaeHong_Boj_1932_정수_삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) { // 피라미드 입력
            for (int j = 1; j <= i; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
        // dp[i][j] == 이제까지 선택된 수의 합이 최대
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                // 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택
                dp[i][j] = Math.max(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j]);
            }
        }


        // 마지막 층에서 가장 큰 수를 찾기
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}
