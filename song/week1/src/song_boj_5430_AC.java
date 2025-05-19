/*
 * 링크: https://www.acmicpc.net/problem/5430
 * 티어: 골드 V
 * 키워드: 덱, 문자열 파싱
 * 문제 요약:
 *   - R: 배열 방향 전환, D: 현재 방향 기준 첫 번째 요소 제거
 *   - 배열이 비어 있을 때 D를 수행하면 error 출력
 */

import java.util.*;

public class song_boj_5430_AC {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // 테스트 케이스의 개수

        while (t-- > 0) {
            String p = sc.next();  // 수행할 함수
            int n = sc.nextInt(); sc.nextLine();  // 배열의 크기

            String arrInput = sc.nextLine();  // 배열

            Deque<Integer> deque = new ArrayDeque<>();

            // 입력 배열 파싱
            if (n > 0) {
                arrInput = arrInput.substring(1, arrInput.length() - 1);  // 대괄호 [] 제거
                String[] elements = arrInput.split(",");
                for (String e : elements) {
                    deque.offer(Integer.parseInt(e));
                }
            }

            boolean isReversed = false;  // 현재 뒤집혔는지 여부
            boolean error = false;       // 에러 발생 여부

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;  // 뒤집기
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!isReversed) {
                        deque.pollFirst();  // 맨 앞 버리기
                    } else {
                        deque.pollLast();   // 맨 뒤 버리기
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (!isReversed) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);  // 전체 출력
    }
}
