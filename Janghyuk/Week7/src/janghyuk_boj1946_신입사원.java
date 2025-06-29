import java.io.*;
import java.util.*;

public class janghyuk_boj1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int[n][2];


            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // arr[0] 값 기준으로 정렬 (서류)
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            // 서류1등은 무조건 포함
            int count = 1;
            int interview = arr[0][1];

            for (int i = 1; i < n; i++) {
                if (arr[i][1] < interview) {
                    count++;
                    interview = arr[i][1];
                }
            }

            System.out.println(count);
        }

    }

}

