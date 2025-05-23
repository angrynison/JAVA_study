/*
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 난이도: Lv.3
 * 키워드: 하향식/상향식 DP
 * 문제 요약:
 *   - 정수 삼각형 꼭대기에서 바닥까지 내려가는 경로 중, 숫자의 합이 가장 큰 경로의 합 구하기
 */

public class song_pgs_정수삼각형 {
    private static int solution(int[][] triangle) {
        int n = triangle.length;

        // 아래에서 두 번째 줄부터 위로 올라가면서
        // 각 위치에서 아래 두 칸(triangle[i][j]의 왼쪽 아래, 오른쪽 아래) 중 큰 값을 선택해 더하기
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return triangle[0][0];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        }));
    }
}
