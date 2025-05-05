import java.util.PriorityQueue;
import java.util.Scanner;

public class JaeHong_Beakjoon_1715_가드_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int total = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            total += sum;
            pq.offer(sum);
        }
        System.out.println(total);
    }
}
