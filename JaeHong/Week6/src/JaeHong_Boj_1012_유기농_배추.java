import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JaeHong_Boj_1012_유기농_배추 {
    private static final int[] dy = {-1, 1, 0, 0}; // 상하좌우 이동
    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static int[][] field;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        //  0은 배추가 심어져 있지 않은 땅이고
        //  1은 배추가 심어져 있는 땅을 나타낸다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new boolean[n][m];
            ArrayList<int[]> cabbages = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1; // 배추가 심어진 위치를 1로 표시
                cabbages.add(new int[]{y, x}); // 배추 위치 저장
            }

            int count = 0;
            for (int[] cabbage : cabbages) {
                int y = cabbage[0];
                int x = cabbage[1];
                if (!visited[y][x]) {
                    count++;
                    dfs(field, visited, y, x);
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[][] field, boolean[][] visited, int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (field[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(field, visited, ny, nx);
            }
        }
    }
}
