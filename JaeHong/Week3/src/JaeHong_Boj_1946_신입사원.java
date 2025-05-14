import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class JaeHong_Boj_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, Comparator.comparingInt(score -> score[0]));

            int count = 1; // 서류 1등은 무조건 합격
            int topInterviewRank = scores[0][1]; // 최고 면접 등수

            for (int j = 1; j < n; j++) {
                if (scores[j][1] < topInterviewRank) {
                    count++;
                    topInterviewRank = scores[j][1];
                }
            }
            System.out.println(count);
        }
    }
}
