/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 레벨: Lv.2
 * 태그: 힙
 * 문제 요약:
 *   - 스코빌 지수가 K 이상이 되도록 가장 맵지 않은 두 음식을 섞는 최소 횟수 구하기
 */

import java.util.*;

public class song_pgs_더맵게 {
    public static int solution(int[] scoville, int K) {
        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.offer(i);

        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll(), b = pq.poll();
            pq.offer(a + 2 * b);
            cnt++;
        }

        return (pq.peek() >= K) ? cnt : -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}