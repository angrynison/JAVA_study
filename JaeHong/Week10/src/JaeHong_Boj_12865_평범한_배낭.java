import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JaeHong_Boj_12865_평범한_배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물건 정보를 저장할 2차원 배열 (무게, 가치)
        // 인덱스를 1부터 사용하기 위해 N+1 크기로 선언
        int[][] items = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // Weight
            items[i][1] = Integer.parseInt(st.nextToken()); // Value
        }

        // dp[i][w]는 i번째 물건까지 고려하고, 무게 한도가 w일 때의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // i: 물건 인덱스
        for (int i = 1; i <= N; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            // w: 현재 배낭의 무게 한도
            for (int w = 1; w <= K; w++) {
                // 현재 물건의 무게가 한도(w)보다 크면 담을 수 없음
                if (weight > w) {
                    dp[i][w] = dp[i - 1][w]; // 이전 물건까지의 최적값을 그대로 가져옴
                } else {
                    // 담을 수 있는 경우
                    // (이전 물건까지의 최적값) vs (현재 물건을 담는 경우의 가치) 중 큰 값을 선택
                    int dontPack = dp[i - 1][w]; // 현재 물건을 담지 않음
                    int pack = value + dp[i - 1][w - weight]; // 현재 물건을 담음
                    dp[i][w] = Math.max(dontPack, pack);
                }
            }
        }

        // 최종 결과 출력
        // N개의 물건을 모두 고려하고, 무게 한도가 K일 때의 최대 가치
        System.out.println(dp[N][K]);
    }
}