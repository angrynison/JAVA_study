import java.util.ArrayList;
import java.util.Scanner;

public class JiHyeon_boj_2606_virus {

    static ArrayList<Integer>[] graph; // graph[node] 는 node와 인접한 노드들의 정보가 리스트로 담김
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 노드의 수
        int M = scanner.nextInt(); // 간선의 수

        graph = new ArrayList[N+1]; // 노드는 1부터 시작
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>(); // null으로 초기화
        }

        for(int i=0; i<M; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            addEdge(u,v);
        }

        DFS(1);
        System.out.println(count-1); // 1번 컴퓨터는 제외
    }

    static void addEdge(int u, int v){
        graph[u].add(v);
        graph[v].add(u);
    }
    static void DFS(int node){
        visited[node] = true;
        count++;

        for(int next : graph[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
