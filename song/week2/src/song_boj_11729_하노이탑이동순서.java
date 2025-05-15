/*
 * 링크: https://www.acmicpc.net/problem/11729
 * 레벨: 골드 Ⅴ
 * 키워드: 재귀, 분할정복
 * 문제 요약:
 *   - 하노이 탑 이동 횟수와 경로 출력
 */
import java.util.*;

public class song_boj_11729_하노이탑이동순서 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 이동 횟수
        sb.append(hanoi(n)).append("\n");

        // 이동 경로
        move(n, 1, 3, 2);

        System.out.println(sb);
    }

    private static int hanoi(int n) {
        if (n == 1) return 1;
        return hanoi(n - 1) * 2 + 1;
    }

    private static void move(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        // n - 1개 원판 보조 장대로 옮기기
        move(n - 1, from, via, to);

        // 가장 큰 원판 목표 장대로 옮기기
        sb.append(from).append(" ").append(to).append("\n");

        // 다시 n - 1개 원판 목표 장대로 옮기기
        move(n - 1, via, to, from);
    }
}
