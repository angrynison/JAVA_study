/*
 * 링크: https://www.acmicpc.net/problem/11399
 * 티어: 실버4
 * 태그: 그리디알고리즘, 정렬
 * 문제 요약:
 *   - 모두가 돈을 인출하는 데 필요한 시간의 합을 최소로 하려면
 *   - 각 사람이 돈을 인출하는 데 걸리는 시간을 짧은 순으로 정렬한 후 누적합을 구해야 한다.
 */

import java.util.*;

public class song_boj_11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0, total = 0;
        for (int time : arr) {
            sum += time;
            total += sum;
        }

        System.out.println(total);
    }
}