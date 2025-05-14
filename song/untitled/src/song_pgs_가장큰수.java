/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 레벨: Lv.2
 * 태그: 정렬
 * 문제 요약:
 *   - 정수 문자열을 이어붙였을 때 큰 쪽이 앞에 오도록 정렬
 */

import java.util.*;

public class song_pgs_가장큰수 {
    public static String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 정렬 기준 커스텀: (a + b)와 (b + a)를 비교
        // Arrays.sort(arr, (a, b) -> ...)
        // (a, b) -> 음수이면 a가 앞에 오고, 양수이면 b가 앞에 온다. 0이면 순서 유지
        // a.compareTo(b)
        // 반환값이 음수이면 a < b, 0이면 a == b, 양수이면 a > b
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 모든 수가 0인 경우 예외 처리
        if (strNums[0].equals("0")) return "0";

        // 문자열 배열을 이어붙여서 결과 반환
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}