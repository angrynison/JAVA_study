import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int []dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {  // dp 테이블을 다채워야함
            for (int j = 0; j < i; j++) {   // i 이전 값들을 순회하는 거임
                if (arr[i] > arr[j]) { // 이전 arr 값(들)이 현재 arr 값보다 작으면서
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // DP 테이블이 최대인 것을 구해 + 1 을 해준다 (이전 값들을 순회)
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}