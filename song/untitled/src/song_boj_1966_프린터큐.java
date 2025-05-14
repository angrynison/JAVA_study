/*
 * 링크: https://www.acmicpc.net/problem/1966
 * 티어: 실버3
 * 날짜: 2025-04-25
 * 태그: 자료구조, 구현, 큐, 시뮬레이션
 * 문제 요약:
 *   - 문서를 중요도 순서대로 인쇄할 때, 특정 문서의 인쇄 순서 출력
 */

import java.util.*;

public class song_boj_1966_프린터큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<int[]> queue = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                int priority = sc.nextInt();
                queue.offer(new int[]{j, priority});
            }

            int count = 0;

            while (true) {
                int max = 0;
                for (int[] doc : queue) {
                    max = Math.max(max, doc[1]);
                }

                int[] current = queue.poll();

                if (current[1] == max) {
                    count++;
                    if (current[0] == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }
    }
}