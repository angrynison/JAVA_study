import java.util.Scanner;

public class JaeHong_Boj_1987_알파벳 {
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 이동
    static boolean[] alphabet = new boolean[26]; // 알파벳 방문 여부
    static boolean[][] visited;
    static char[][] chars;
    static int r, c;
    static int depth = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        chars = new char[r][c];
        visited = new boolean[r][c]; // 방문 여부를 1차원 배열로 관리
        for (int i = 0; i < r; i++) {
            String string = sc.nextLine();
            for (int j = 0; j < c; j++) {
                chars[i][j] = string.charAt(j);
            }
        }
        visited[0][0] = true; // 현재 위치 방문
        alphabet[chars[0][0] - 'A'] = true; // 현재 알파벳 방문
        dfs(0, 0, depth); // 시작 위치 (0, 0)에서 시작
        System.out.println(depth);
    }

    private static void dfs(int row, int col ,int curdepth) {
        for (int i = 0; i < 4; i++) {
            int nr = row + dy[i];
            int nc = col + dx[i];
            if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
            if (!visited[nr][nc] && !alphabet[chars[nr][nc] - 'A']) {
                visited[nr][nc] = true; // 다음 위치 방문
                alphabet[chars[nr][nc] - 'A'] = true; // 다음 알파벳 방문
                dfs(nr, nc, curdepth + 1); // 재귀 호출

                // --- 백트래킹 시작 ---
                // 재귀 호출이 반환되었다는 것은 (nr, nc)에서 시작하는 모든 하위 경로 탐색이 끝났다는 의미.
                // 또는 (nr, nc)에서 더 이상 갈 곳이 없었다는 의미.
                visited[nr][nc] = false; // 백트래킹
                alphabet[chars[nr][nc] - 'A'] = false; // 백트래킹
                depth = Math.max(depth, curdepth + 1); // 최대 깊이 갱신
                // depth가 최대 깊이를 갱신하는 부분은 재귀 호출 후에 위치해야 합니다.
                // depth + 1은 현재까지 갈 수 있는 최대 깊이를 의미
            }
        }
    }
}
