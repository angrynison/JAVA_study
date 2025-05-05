import java.util.*;
class ScovilleSolution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // k이상일 때까지 반복해서 섞는다.
        // 가장 안매운 음식 + (두번쨰로 안매운 음식*2)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int food: scoville){ // 값 순서와 상관없이 알아서 내부 최소힙 구조 유지
            heap.add(food);
        }

        // poll() 루트 요소를 삭제하고 반환한다.
        // peek() 루트 요소를 조회한다. 삭제하지 않음
        while(heap.size()>=2 && heap.peek()<K){
            int first = heap.poll();
            int second = heap.poll();

            int new_food = first+(second*2);
            heap.add(new_food);
            answer++;
        }

        if(heap.peek()<K){
            answer = -1;
        }


        return answer;
    }
}

public class JiHyeon_programmers_더맵게 {
}