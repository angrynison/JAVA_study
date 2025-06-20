import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JaeHong_Boj_1946_신입_사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] scores = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, Comparator.comparingInt(a -> a[0])); // 1차원 기준으로 정렬
            int cnt = 1;
            for (int[] score : scores) {
                if (score[1] < scores[0][1]) { // 현재 점수가 첫 번째 지원자의 2차원 점수보다 낮으면
                    cnt++; // 카운트 증가
                    scores[0][1] = score[1]; // 첫 번째 지원자의 2차원 점수를 갱신 -> 비교용
                }
            }
            System.out.println(cnt);
        }
    }
}
