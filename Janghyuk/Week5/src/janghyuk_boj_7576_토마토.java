import java.util.*;

public class janghyuk_boj_7576_토마토 {

    static int[][] board = new int[1002][1002]; // 토마토 상태저장 2차원 배열
    static int[][] dist = new int[1002][1002];  // 	각 칸 마다 최소 익는 날짜를 저장
    static int[] dx = {1, 0, -1, 0};  // 상하좌우 이동
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 열
        n = sc.nextInt(); // 행

        Queue<int[]> q = new LinkedList<>();

        // 1 -> 익은 토마토, 0 -> 안 익은 토마토, -1 -> 빈칸
        // 입력 및 초기 데이터 큐에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});  // 익은 토마토는 큐에 추가함 (bfs 시작점이기 때문에)
                } else if (board[i][j] == 0) {
                    dist[i][j] = -1; // 안 익은 토마토는 거리 -1로 초기화 (아직 dfs 방문전이기 때문)
                }
            }
        }

        // BFS 구현 BFS로 익은 토마토를 퍼뜨려 나가며 날짜를 기록
        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 현재 좌표
            for (int dir = 0; dir < 4; dir++) { // 상하좌우
                int nx = cur[0] + dx[dir]; // 다음 x 좌표
                int ny = cur[1] + dy[dir]; // 다음 y 좌표
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 정해진 칸의 규격을 벗어나면 넘어감
                if (dist[nx][ny] >= 0) continue;  // 이미 방문 (= 이미 익은 토마토) 했으면 넘어감
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // 하루 더 익음
                q.offer(new int[]{nx, ny}); // 큐에 추가 x,y
            }
        }

        // 결과 계산
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1); // 안 익은 토마토 존재 시 실패
                    return;
                }
                ans = Math.max(ans, dist[i][j]); // // 최대 며칠
            }
        }

        System.out.println(ans);
    }
}

