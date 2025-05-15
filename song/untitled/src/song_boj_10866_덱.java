/*
 * 링크: https://www.acmicpc.net/problem/10866
 * 티어: 실버4
 * 날짜: 2025-04-26
 * 태그: 자료구조, 구현, 덱
 * 문제 요약:
 *   - 덱 기본 명령어(push_front, push_back, pop_front, pop_back, size, empty, front, back) 구현
 */

import java.util.*;

public class song_boj_10866_덱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        while (n-- > 0) {
            String cmd = sc.next();

            if (cmd.equals("push_front")) {
                int x = sc.nextInt();
                deque.addFirst(x);
            } else if (cmd.equals("push_back")) {
                int x = sc.nextInt();
                deque.addLast(x);
            } else if (cmd.equals("pop_front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
            } else if (cmd.equals("pop_back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
            } else if (cmd.equals("size")) {
                System.out.println(deque.size());
            } else if (cmd.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);
            } else if (cmd.equals("front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
            } else if (cmd.equals("back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }
        }
    }
}