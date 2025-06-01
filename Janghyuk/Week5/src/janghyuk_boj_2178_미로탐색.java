import java.util.*;

public class janghyuk_boj_2178_미로탐색 {
    static int n, m;
    static String[] board = new String[102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] >= 0 || board[nx].charAt(ny) != '1') continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        // 시작점 포함이므로 거리 + 1
        System.out.println(dist[n - 1][m - 1] + 1);
    }
}
