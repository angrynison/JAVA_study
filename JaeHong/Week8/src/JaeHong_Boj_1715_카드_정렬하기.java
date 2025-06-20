import java.util.PriorityQueue;
import java.util.Scanner;

public class JaeHong_Boj_1715_카드_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(sc.nextInt());
        }

        int result = 0;
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            System.out.println(priorityQueue.poll() + priorityQueue.poll());
        } else {
            while (priorityQueue.size() > 1) {
                Integer a = priorityQueue.poll();
                Integer b = priorityQueue.poll();
                int e = a + b; // 두 카드 묶음의 합
                result += e; // 결과에 합산
                // 두 카드 묶음을 다시 우선순위 큐에 추가
                priorityQueue.add(e);
            }
            System.out.println(result);
        }
    }
}
