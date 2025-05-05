/*
 * 링크: https://www.acmicpc.net/problem/2630
 * 티어: 실버2
 * 태그: 분할정복, 재귀
 * 문제 요약:
 *   - N × N 색종이의 조각이 모두 같은 색으로 칠해져 있는 상태가 될 때까지 4등분
 */

import java.util.*;

public class song_boj_2630_색종이만들기 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        paper = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                paper[i][j] = sc.nextInt();

        cut(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void cut(int r, int c, int size) {
        int color = paper[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            if (color == 0) white++;
            else blue++;
        } else {
            int half = size / 2;
            cut(r, c, half);
            cut(r, c + half, half);
            cut(r + half, c, half);
            cut(r + half, c + half, half);
        }
    }
}