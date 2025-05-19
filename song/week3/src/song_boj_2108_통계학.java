/*
 * 링크: https://www.acmicpc.net/problem/2108
 * 난이도: 실버 Ⅱ
 * 키워드: 정렬, 구현
 * 문제 요약:
 *   - N개의 수를 입력받아 산술평균, 중앙값, 최빈값, 범위를 차례로 출력
 */
import java.io.*;
import java.util.*;

public class song_boj_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 단, n은 홀수
        int[] arr = new int[n];

        double sum = 0.0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // 합계
            sum += arr[i];
            // 빈도수 카운트
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);

        int maxFreq = Collections.max(map.values());  // 빈도수 최대값
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {  // 해당 키의 값(빈도수)이 빈도수 최대값과 같으면
                list.add(key);
            }
        }
        Collections.sort(list);

        // 산술평균(소수점 첫째자리 반올림)
        System.out.println(Math.round(sum / arr.length));

        // 중앙값
        System.out.println(arr[arr.length / 2]);

        // 최빈값(여러 개 있을 때에는 두 번째로 작은 값)
        System.out.println(list.size() > 1 ? list.get(1) : list.get(0));

        // 범위
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}
