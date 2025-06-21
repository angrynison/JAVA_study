import java.util.Arrays;
import java.util.Scanner;

public class JiHyeon_boj_1654_linecut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] lines = new int[K];
        int result = 0;

        for(int i=0; i<K; i++){
            lines[i] = scanner.nextInt();
        }

        Arrays.sort(lines);

        int low = 1;
        int high = lines[K-1];

        while (low <= high){
            int mid = (low+high)/2;
            int count = 0;
            for(int i=0; i<K; i++) {
                count += lines[i]/mid; // 몫
            }
            if (count >= N){
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(result);

    }
}
