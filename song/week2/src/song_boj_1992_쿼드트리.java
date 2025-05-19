/*
 * 링크: https://www.acmicpc.net/problem/1992
 * 난이도: 실버 I
 * 키워드: 재귀, 분할정복
 * 문제 요약:
 *   -
 */
import java.util.*;

public class song_boj_1992_쿼드트리 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        compress(0, 0, n);

        System.out.println(sb);
    }

    private static void compress(int x, int y, int n) {
        int first = arr[x][y];
        boolean same = true;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            sb.append(first);
            return;
        }

        int half = n / 2;
        sb.append("(");

        compress(x, y, half);                      // 왼쪽 위
        compress(x, y + half, half);            // 오른쪽 위
        compress(x + half, y, half);            // 왼쪽 아래
        compress(x + half, y + half, half);  // 오른쪽 아래

        sb.append(")");
    }
}
