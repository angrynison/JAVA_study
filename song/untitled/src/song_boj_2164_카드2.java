/*
 * 링크: https://www.acmicpc.net/problem/2164
 * 티어: 실버4
 * 날짜: 2025-04-25
 * 태그: 자료구조, 큐
 * 문제 요약:
 *   - 맨 위 카드를 버리고, 다음 카드를 맨 아래로 보낸다.
 *   - 마지막에 남는 카드를 출력
 */

import java.util.*;

public class song_boj_2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 카드의 개수

        Queue<Integer> queue = new ArrayDeque<>();  // ArrayDeque으로 큐 생성
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 카드가 1장 남을 때까지 반복
        while (queue.size() > 1) {
            queue.poll();               // 맨 위 카드를 버림
            queue.offer(queue.poll());  // 다음 카드를 맨 아래로 보냄
        }

        // 마지막 남은 카드 출력
        System.out.println(queue.peek());
    }
}