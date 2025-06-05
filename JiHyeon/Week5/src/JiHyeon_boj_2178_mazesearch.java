import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JiHyeon_boj_2178_mazesearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // (N x M) 크기의 배열
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            String[] strArr = scanner.next().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        // 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int sx = 0;
        int sy = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // init
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while(!queue.isEmpty()) {
            int[] outputPoint = queue.poll();
            int x = outputPoint[0];
            int y = outputPoint[1];

            // 상하좌우 이동
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효 범위 정하기
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 미방문이고, 이동가능
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        // 거리 기반으로 더해야함
                        // 다음 칸까지의 거리 = 현재 칸까지의 거리 + 1
                        arr[nx][ny] = arr[x][y] + 1;
                        // 이웃들 큐에 추가
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

        }

        System.out.println(arr[N - 1][M - 1]);
    }
}
