import java.util.Arrays;
import java.util.Scanner;

public class JaeHong_Boj_1654_랜선_자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] cables = new long[k];
        for (int i = 0; i < k; i++) {
            cables[i] = sc.nextLong();
        }
        Arrays.sort(cables);
        // 찾는 대상 : 랜선의 최대 길이
        long left = 1; // 최소 길이
        long right = cables[k - 1]; // 최대 길이 = 가진 케이블 중 최대 길이 // 2^31-1
        long answer = 0;

        // 왼쪽이 커지면 끝난다
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long cable : cables) {
                count += cable / mid; // 현재 길이로 만들 수 있는 랜선의 개수
            }

            if (count >= n) { // 필요한 랜선의 개수 이상이면
                answer = mid; // 최대 랜선 길이를 갱신
                left = mid + 1; // 더 긴 랜선 길이를 찾기 위해 왼쪽 범위를 이동
            } else {
                right = mid - 1; // 필요한 랜선의 개수가 부족하면 오른쪽 범위를 이동
            }
        }
        System.out.println(answer); // 최대 랜선 길이 출력
    }
}
