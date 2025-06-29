import java.io.*;
import java.util.*;

public class janghyuk_boj_11724 {


    static boolean visited[];
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>(); // 각 노드의 연결 리스트 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        int ans = 0;

        for (int i = 1; i < n+1; i++) { // 최악
            if (!visited[i]) { // 방문하지 않은 노드면
                ans++; // 새로운 요소임
                DFS(i);
            }
        }

        System.out.println(ans);
    }

    private static void DFS(int v) {

        if (visited[v]) { // 이미 방문한거면 return
            return;
        }

        visited[v] = true;   //  방문하지 않았다면 참으로 바꾸고 연결돼있는 노드를 찾아야됨

        for (int i : list[v]) { // 연결돼있는 노드를 찾자
            if (!visited[i]) {
                DFS(i);
            }

        }
    }
}
