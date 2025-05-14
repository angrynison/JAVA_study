/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 레벨: Lv.2
 * 키워드: 정렬, 그리디
 * 문제 요약:
 *   - 정수를 이어붙여 만들 수 있는 수 중 가장 큰 수를 문자열로 반환
 *   - "이어붙였을 때 더 큰 조합"을 기준으로 정렬
 */
import java.util.*;

public class song_pgs_가장큰수 {
    private static String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 정렬 기준 커스텀: (a + b)와 (b + a)를 비교
        // Arrays.sort(arr, (a, b) -> ...)
        // (a, b) -> 음수이면 a가 앞에 오고, 양수이면 b가 앞에 온다. 0이면 순서 유지
        // a.compareTo(b)
        // a < b이면 음수, a == b이면 0, a > b이면 양수를 반환
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
