/*
 * 링크: https://www.acmicpc.net/problem/2751
 * 난이도: 실버 V
 * 키워드: 정렬
 * 문제 요약:
 *   - 주어진 N개의 정수를 오름차순으로 정렬하여 한 줄에 하나씩 출력
 *   - 빠른 입출력 필요
 */
import java.io.*;
import java.util.*;

public class song_boj_2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        for (int num : arr) {
            bw.write(num + "\n");
        }

        bw.flush();
    }
}
