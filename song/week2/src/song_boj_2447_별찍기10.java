/*
 * 링크: https://www.acmicpc.net/problem/2447
 * 난이도: 골드 Ⅴ
 * 키워드: 재귀, 분할정복
 * 문제 요약:
 *   - 가운데는 비우고 나머지 8칸은 크기 N/3의 패턴으로 둘러싼 크기 N의 패턴 출력
 */
import java.util.*;

public class song_boj_2447_별찍기10 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];

        star(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void star(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int block = n / 3;

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                int nx = x + dx * block;
                int ny = y + dy * block;

                if (dx == 1 && dy == 1) {
                    for (int i = x; i < x + n; i++) {
                        for (int j = y; j < y + n; j++) {
                            arr[i][j] = ' ';
                        }
                    }
                } else {
                    star(nx, ny, block);
                }
            }
        }
    }
}
