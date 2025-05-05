import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JaeHong_Beakjoon_11286_절댓값_힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> Math.abs(o)).thenComparingInt(o -> o));

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                int result = Math.abs(o1) - Math.abs(o2);
//                if (result == 0) {
//                    result = Integer.compare(o1, o2);
//                }
//                return result;
//            }
//        });

        for (int i = 0; i < n; i++) {
            int i1 = sc.nextInt();
            if (i1 == 0) {
                if (!pq.isEmpty()) {
                    Integer polled = pq.poll();
                    System.out.println(polled);
                } else {
                    System.out.println(0);
                }
            } else {
                pq.add(i1);
            }
        }
    }
}
