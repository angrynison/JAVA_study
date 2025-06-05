import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JiHyeon_boj_7576_tomato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

//        // 시작지점을 강제로 -> 1위치 각각 확산됨으로 틀림!
//        int sx = 0;
//        int sy = 0;
//        for(int i=0; i<M; i++) {
//            for(int j=0; j<N; j++){
//                if(arr[i][j] ==1){
//                    sx = i;
//                    sy = j;
//                }
//            }
//        }
//        queue.offer(new int[]{sx,sy});
//        visited[sx][sy]= true;

        // 초기에 1인 위치를 큐에 넣는다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                if(arr[i][j] ==1){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!visited[nx][ny] && arr[nx][ny]==0){
                        visited[nx][ny] = true;
                        // 안익은 칸을 익은 칸으로 바꿈
                        arr[nx][ny] = arr[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        int max = 0;
        boolean check = false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]==0){
                    check = true;
//                    System.out.println(-1);
//                    break;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        if(check){
            System.out.println(-1);
        }
        else System.out.println(max - 1);

    }
}
