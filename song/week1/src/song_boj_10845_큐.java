/*
 * 링크: https://www.acmicpc.net/problem/10845
 * 티어: 실버4
 * 날짜: 2025-04-25
 * 태그: 자료구조, 구현, 큐
 * 문제 요약:
 *   - 큐 기본 명령어(push, pop, size, empty, front, back) 구현
 */

import java.util.*;

public class song_boj_10845_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 양방향 큐 기능을 사용하기 위해 Deque 인터페이스로 선언
        Deque<Integer> queue = new ArrayDeque<>();

        while (n-- > 0) {
            String cmd = sc.next();

            if (cmd.equals("push")) {
                int x = sc.nextInt();
                queue.offer(x);
            } else if (cmd.equals("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (cmd.equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if (cmd.equals("back")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            }
        }
    }
}