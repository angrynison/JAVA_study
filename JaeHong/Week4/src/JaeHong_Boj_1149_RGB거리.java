import java.util.Scanner;

public class JaeHong_Boj_1149_RGB거리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            // i번째 집의 R, G, B 색깔 비용
            dp[i][0] = scanner.nextInt();
            dp[i][1] = scanner.nextInt();
            dp[i][2] = scanner.nextInt();
        }

        // 이전 색과 같으면 안됨
        for (int i = 2; i <= n; i++) {
            // R[i] = min(G[i-1], B[i-1]) + R[i]
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            // G[i] = min(R[i-1], B[i-1]) + G[i]
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            // B[i] = min(R[i-1], G[i-1]) + B[i]
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
