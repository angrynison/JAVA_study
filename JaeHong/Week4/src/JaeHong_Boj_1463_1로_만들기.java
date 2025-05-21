import java.util.Arrays;
import java.util.Scanner;

public class JaeHong_Boj_1463_1로_만들기 {
    public static void main(String[] args) {
        // 이것도 상향식
        // 최소값 찾기 >> 최대값으로 초기화하기
        // dp[i] = 1을 만들기 위한 최소 횟수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] +1;
            if ((i % 2) == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if ((i % 3) == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        System.out.println(dp[n]);
    }
}
