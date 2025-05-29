import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JaeHong_Boj_1260_DFS와_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1 ; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= n ; i++) {
            graph[i].sort(Integer::compareTo);
        }

        dfs(graph, new boolean[n + 1], s);
        System.out.println();
        bfs(graph, new boolean[n + 1], s);

    }

    private static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (Integer i : graph[start]) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (Integer i : graph[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

}
