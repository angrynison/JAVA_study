/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * 난이도: Lv.3
 * 키워드: 중복 제거 DP
 * 문제 요약:
 *   - 정수 N과 사칙연산만 사용해서 number를 만드는 방법 중 N을 최소로 사용하는 경우
 */
import java.util.*;

public class song_pgs_N으로표현 {
    private static int solution(int N, int number) {
        // N을 한 번만 사용해서 number를 만들 수 있는 경우
        if (N == number) return 1;

        // dp[i] = N을 i번 사용해서 만들 수 있는 숫자 집합
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int num = 0;
            for (int n = 0; n < i; n++) {
                num = num * 10 + N;  // N을 i번 이어붙인 수(5, 55, 555, ...)
            }
            dp.get(i).add(num);

            for (int j = 1; j < i; j++) {
                // dp[3] = dp[1](연산)dp[2] + dp[2](연산)dp[1]
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);  // 0으로 나누는 경우는 제외
                    }
                }
            }

            // number가 dp[i]에 포함되어 있다면 -> N을 i번 사용해서 number를 만들 수 있음
            if (dp.get(i).contains(number)) return i;
        }

        // 최솟값이 8보다 클 때
        return -1;
    }

    public static void main (String[] args){
            System.out.println(solution(5, 12));
            System.out.println(solution(2, 11));
    }
}
