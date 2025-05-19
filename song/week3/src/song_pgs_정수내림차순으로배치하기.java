/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12933
 * 난이도: Lv.1
 * 키워드: 정렬, 문자열
 * 문제 요약:
 *   - 주어진 자연수의 각 자릿수를 큰 숫자부터 작은 숫자 순으로 정렬한 새로운 정수 반환
 */
import java.util.*;

public class song_pgs_정수내림차순으로배치하기 {
    private static long solution(long n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add((int)(n % 10));  // 1의 자리부터 분해
            n /= 10;
        }

        // 내림차순 정렬
        list.sort(Collections.reverseOrder());

        long answer = 0;
        for (int num : list) {
            answer = answer * 10 + num;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
