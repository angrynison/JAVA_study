import java.util.PriorityQueue;
import java.util.Scanner;

public class JiHyeon_boj_1715_cardsorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐를 사용한다.
        // 계속 작은값 2개를 먼저 꺼낸다.
        // 두 값의 합을 다시 우선순위 큐에 넣는다.
        // 우선순위 큐에 의해서 자동 정렬된다.
        // 우선순위 큐의 길이가 1일 때까지
        for(int i=0; i<N; i++){
            pq.add(scanner.nextInt());
        }

        int total = 0;
        while (pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            total+=sum;
            pq.add(sum);
        }
        System.out.println(total);
    }

}
