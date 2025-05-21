import java.util.Scanner;

public class JaeHong_Boj_11726_2xn타일링 {
    private final static int DIVISOR = 10_007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 상향식
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long prev2 = 1; // 2x1 넣었을 때
        long prev1 = 2; // 1x2 넣었을 때
        for (int i = 3; i <= n; i++) {
            long current = (prev1 + prev2) % DIVISOR;
            // 한 칸씩 땡기기
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
