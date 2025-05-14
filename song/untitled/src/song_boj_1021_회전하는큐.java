/*
 * 링크: https://www.acmicpc.net/problem/1021
 * 티어: 실버3
 * 날짜: 2025-04-26
 * 태그: 자료구조, 덱
 * 문제 요약:
 *   - 원하는 숫자를 덱에서 꺼낼 때, 최소 회전 횟수로 꺼낸다
 *   - 왼쪽/오른쪽 회전 중 더 빠른 방향 선택
 */

import java.util.*;

public class song_boj_1021_회전하는큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 큐의 크기
        int m = sc.nextInt();  // 뽑아내야 할 숫자의 개수

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();  // ArrayDeque으로 덱 생성
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int count = 0;  // 회전 횟수

        for (int target : arr) {
            // 현재 target의 위치
            int idx = 0;
            for (int num : deque) {
                if (num == target) {
                    break;
                }
                idx++;
            }

            // target이 앞쪽에 있으면 왼쪽으로 돌리는 게 빠름
            if (idx <= deque.size() / 2) {
                // target이 맨 앞으로 올 때까지
                while (deque.peekFirst() != target) {
                    // 왼쪽으로 한 칸 이동
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            // target이 뒤쪽에 있으면 오른쪽으로 돌리는 게 빠름
            else {
                // target이 맨 앞으로 올 때까지
                while (deque.peekFirst() != target) {
                    // 오른쪽으로 한 칸 이동
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            // target 뽑아내기
            deque.pollFirst();
        }

        // 회전 횟수 출력
        System.out.println(count);
    }
}