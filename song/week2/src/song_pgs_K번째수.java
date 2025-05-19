/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * 난이도: Lv.1
 * 태그: 정렬
 * 문제 요약:
 *   - 주어진 배열을 슬라이싱하고 정렬한 부분 배열에서 k번째 수 구하기
 */
import java.util.*;

public class song_pgs_K번째수 {
    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] command : commands) {
            int i = command[0], j = command[1], k = command[2];

            // 슬라이싱
            int[] sliced = Arrays.copyOfRange(array, i - 1, j);

            // 정렬
            Arrays.sort(sliced);

            // k번째 값 저장
            answer[idx++] = sliced[k - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
