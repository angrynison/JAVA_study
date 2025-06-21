import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JiHyeon_boj_1946_newEmployee {
    public static void main(String[] args) throws IOException {
        // Scanner => BufferedReader + StringTokenizer
        // BufferedReader는 한 줄 전체를 문자열(string) 으로 읽는다.
        // Integer.parseInt 로 문자열 -> 숫자 변환

        // StringTokenizer는 문자열을 공백 기준으로 자른다.
        // st.nextToken() 으로 인덱스 없이, 순서대로 하나씩 꺼낸다.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int j=0; j<T; j++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
                arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);
            int count = 1; // 서류 1등은 무조건 합격
            int interviewScore = arr[0][1]; // 현재 최소 면접 점수

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < interviewScore) {
                    count++;
                    interviewScore = arr[i][1];
                }
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
