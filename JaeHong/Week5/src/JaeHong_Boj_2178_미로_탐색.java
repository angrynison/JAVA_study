import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class JaeHong_Boj_2178_미로_탐색 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        System.out.println(bfs(maze, visited, n, m));
    }

    private static int bfs(int[][] maze, boolean[][] visited, int n, int m) {
        int[][] distance = new int[n][m];
        distance[0][0] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return distance[n-1][m-1];
    }
}
