import java.util.*;

public class JaeHong_Beakjoon_11000_강의실_배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            lectures[i][0] = sc.nextInt(); // 시작 시간
            lectures[i][1] = sc.nextInt(); // 종료 시간
        }

        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료 시간 저장용 최소 힙

        pq.offer(lectures[0][1]); // 가장 빨리 끝나는 강의 종료 시간

        for (int i = 1; i < n; i++) {
            // 가장 빨리 끝나는 강의실과 현재 강의 시작 시간 비교
            if (lectures[i][0] >= pq.peek()) {
                pq.poll(); // 기존 강의실 사용 가능
            }
            pq.offer(lectures[i][1]); // 현재 강의 종료 시간 삽입
        }
        System.out.println(pq.size()); // 필요한 강의실 수
    }
}