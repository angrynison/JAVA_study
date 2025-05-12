import java.util.*;
import java.io.*;

public class janghyuk_boj_2512_예산 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 지방 수
        int[] requests = new int[n];
        int max = 0;    // 요청 중 최댓값

        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
            if (requests[i] > max) {
                max = requests[i];
            }
        }

        int budget = sc.nextInt();  // 총 예산

        int left = 0;
        int right = max;

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;  // 상한액 후보
            long total = 0;

            for (int r : requests) {
                total += Math.min(r, mid);
            }

            if (total <= budget) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
