import java.util.Scanner;

public class JaeHong_Boj_15989_123더하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] dp = new int[10001][4];
        // dp[i][0] = 총 가지 수
        // dp[i][1] = 1이 포함되어있는 가지 수
        // dp[i][2] = 1이 없고 2가 포함되어있는 가지 수
        // dp[i][3] = 1과 2가 없고 3이 포함되어있는 가지 수
        dp[1][1] = 1;
        dp[1][0] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][0] = 2;

        dp[3][1] = 2;
        dp[3][2] = 0;
        dp[3][3] = 1;
        dp[3][0] = 3;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i-1][0]; // 그 전에 꺼 다 더하면 됨
            dp[i][2] = dp[i-2][2] + dp[i-2][3]; // 2만 더해서 해결될 경우의 수가 있는가?
            dp[i][3] = dp[i-3][3]; // 3만 더해서 해결될 경우의 수가 있는가?

            dp[i][0] = dp[i][1] + dp[i][2] + dp[i][3];
        }

        for (int tc = 0; tc < t; tc++) {
            int i = sc.nextInt();
            System.out.println(dp[i][0]);
        }

    }
}
