import java.util.Scanner;

public class JiHyeon_boj_1012_organiccabbage {

    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스

        for(int i=0; i<T; i++) {
            M = scanner.nextInt(); // 가로
            N = scanner.nextInt(); // 세로
            int K = scanner.nextInt();

            grid = new int[M][N]; // 아마 자동 0초기화
            visited = new boolean[M][N];

            for(int j=0; j<K; j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                grid[x][y] = 1;
            }

            int count=0;

            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    // 전체칸 모두 탐색
                    // 배추가 있는데 1, visited=false 이면 DFS 새롭게 시작
                    if (grid[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }


    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
