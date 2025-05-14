// 문제 : 백준 11053
// 태크 : DP

// 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열(LIS) 을 구한다.
// 부분이라는 단어를 통해서 DP 문제임을 추축한다.
// LIS의 본질은 각 숫자에 대해 그 숫자를 마지막으로 하는 LIS의 최대 길이를 계산한다.
// dp[i]는 i를 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이

import java.util.Scanner;

public class Dp_11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arrs = new int[N];
        for(int i=0; i<N; i++){
            arrs[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        int max = 0;

        // 순서 j i 로
        // arr[j] < arr[i] 이여야 연결
        for(int i=0; i<N; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){ // 쌓인 값들 처음부터 확인함
                if( arrs[j] < arrs[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        // 무엇을 출력하는가..?
        // 일단 최대 길이를 출력해야 한다.
        System.out.println(max);

    }
}
