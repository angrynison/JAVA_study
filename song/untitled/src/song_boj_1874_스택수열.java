/*
 * 링크: https://www.acmicpc.net/problem/1874
 * 티어: 실버2
 * 날짜: 2025-04-24
 * 태그: 자료구조, 스택
 * 문제 요약:
 *   - 주어진 수열을 만들기 위한 push/pop 순서 찾기
 *   - 수열을 만들 수 없으면 "NO" 출력
 */

import java.util.*;

public class song_boj_1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 수열의 길이

        int[] arr = new int[n];  // 수열 배열
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();  // ArrayDeque으로 스택 생성
        StringBuilder sb = new StringBuilder();  // 결과 저장용
        int num = 1;

        for (int target : arr) {  // 수열 하나씩 확인하며 target 지정
            // 필요한 숫자(target)가 나올 때까지 push
            while (num <= target) {
                stack.push(num);
                sb.append("+\n");  // push -> + 출력
                num++;
            }

            // 스택의 top이 필요한 숫자(target)와 같으면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");  // pop -> - 출력
            }
            // 스택의 top이 필요한 숫자(target)와 다르면 수열 만들기 실패
            else {
                System.out.println("NO");
                return;
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}