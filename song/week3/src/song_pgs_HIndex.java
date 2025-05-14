/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 레벨: Lv.2
 * 키워드: 정렬
 * 문제 요약:
 *   - 인용 횟수가 h회 이상인 논문이 h편 이상인 h의 최댓값 구하기
 */
import java.util.*;

public class song_pgs_HIndex {
    private static int solution(int[] citations) {
        // 인용 횟수 오름차순 정렬
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;  // 현재 위치의 논문보다 많이 인용된 논문의 수
            // 현재 위치의 논문보다 많이 인용된 논문의 수가 현재 위치의 논문의 인용 횟수보다 크면
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;  // 조건에 맞는 h가 없으면 0
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
}
