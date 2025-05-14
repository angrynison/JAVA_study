// 문제 : 백준 11651
// 태그 : 정렬

// 2차원 평면 위의 점 N개가 주어진다. => 2차원 배열에 넣어보자
// y축을 기준으로 먼저 오름차순 정렬을 한다.
// y축을 기준으로 같으면 x축을 기준으로 오름차순 정렬한다.

import java.util.Arrays;
import java.util.Scanner;

public class Sort_11651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] spots = new int[N][2];

        for(int i=0; i<N; i++){
            spots[i][0] = scanner.nextInt();
            spots[i][1] = scanner.nextInt();
        }

        // 2차원 배열의 정렬 => compare + 람다식 사용
        // 1차원 배열의 정렬 => sort()
        Arrays.sort(spots, (a,b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]); // y기준 오름차순
            }
            else {
                return Integer.compare(a[0], b[0]); // x기준 오름차순
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(spots[i][0] + " "+ spots[i][1]);
        }
    }
}
