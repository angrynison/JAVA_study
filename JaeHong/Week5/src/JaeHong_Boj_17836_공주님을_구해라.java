import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class JaeHong_Boj_17836_공주님을_구해라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] castle = new int[n][m];
        int[] sword = new int[2];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
                if (castle[i][j] == 2) {
                    sword[0] = i;
                    sword[1] = j;
                    castle[i][j] = 0;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] distance = new int[n][m];
        distance[0][0] = 1;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;
                if (castle[nx][ny] == 1 || distance[nx][ny] > 0) continue;
                distance[nx][ny] = distance[x][y] + 1;
                q.add(new int[]{nx,ny});
            }
        }

        // 검과 공주 한테 둘다 못 가면 실패
        if (distance[sword[0]][sword[1]] == 0 && distance[n-1][m-1] == 0) {
            System.out.println("Fail");
            return;
        }

        // 공주나 검 한테 못 닿으면 INF 처리
        int princess = (distance[n - 1][m - 1] == 0) ? Integer.MAX_VALUE : distance[n - 1][m - 1] - 1;
        int swordDistance =  (distance[sword[0]][sword[1]] == 0) ? Integer.MAX_VALUE : (distance[sword[0]][sword[1]] -1) +
                    Math.abs(sword[0] - (n - 1)) + Math.abs(sword[1] - (m - 1));

        int ans = Math.min(princess, swordDistance);

        System.out.println((ans > t) ? "Fail" : ans + "");
    }
}
