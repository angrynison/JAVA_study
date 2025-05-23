import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JaeHong_Boj_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) { // i는 1부터 시작
            // dp[i] = 지금 혼자 있는게 큰가? 아니면 이전 것에서 지금 값을 더한 게 더 큰가?
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]); // 최댓값 교체
        }
        System.out.println(max);
    }
}
