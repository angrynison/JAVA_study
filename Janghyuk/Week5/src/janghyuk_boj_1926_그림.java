import java.util.*;
import java.io.*;

public class janghyuk_boj_1926_그림 {

    static int[][] board = new int[502][502];
    static boolean[][] vis = new boolean[502][502];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0; // 그림최대값
        int count = 0;   // 그림 수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || vis[i][j]) continue;
                count++;
                vis[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                int area = 0;

                while (!q.isEmpty()) {
                    area++;
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (vis[nx][ny] || board[nx][ny] != 1) continue;

                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

}
