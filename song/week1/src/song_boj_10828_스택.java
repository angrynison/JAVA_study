/*
 * 링크: https://www.acmicpc.net/problem/10828
 * 티어: 실버 Ⅳ
 * 키워드: 스택, 구현
 * 문제 요약:
 *   - 스택 기본 명령어(push, pop, size, empty, top) 구현
 */

import java.util.*;

public class song_boj_10828_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (n-- > 0) {
            String cmd = sc.next();

            if (cmd.equals("push")) {
                int x = sc.nextInt();
                stack.push(x);
            } else if (cmd.equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (cmd.equals("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}
