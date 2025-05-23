import java.util.Scanner;

public class JaeHong_Boj_2579_계단_오르기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 계단 수
        int n = scanner.nextInt();
        int[] stairs = new int[n + 1];
        stairs[0] = 0;
        for (int i = 1; i <= n; i++) {
            stairs[i] = scanner.nextInt();
        }

        // n이 1인 경우
        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        // 두 가지 경우로 2차원 배열로써 해결했어야함
        // dp[i][0] = i번째 계단에서 두 칸 올라왔을 때
        // dp[i][1] = 1번째 계단에서 한 칸 올라왔을 때
        int[][] dp = new int[n + 1][2];
        //첫 번째 계단
        dp[1][0] = stairs[1]; // 그냥 개념상 인정
        dp[1][1] = stairs[1];

        // 두 번째 계단
        dp[2][0] = stairs[2];
        dp[2][1] = dp[1][0] + stairs[2];

        if (n >= 3) {
            for (int i = 3; i <= n ; i++) {
                // 두 칸 뛴 경우
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];

                // 한 칸 뛴 경우
                dp[i][1] = dp[i - 1][0] + stairs[i];
            }
        }
        System.out.println(Math.max(dp[n][0],dp[n][1]));
    }
}
