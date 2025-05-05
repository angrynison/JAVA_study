/*
 * 링크: https://www.acmicpc.net/problem/1764
 * 티어: 실버4
 * 태그: 자료구조, 해시를사용한집합과맵, 정렬, 문자열, 집합과맵
 * 문제 요약:
 *   - 듣도 못한 사람과 보도 못한 사람이 주어질 때, 두 목록에 모두 포함되는 사람을 사전 순으로 출력
 */

import java.util.*;

public class song_boj_1764_듣보잡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        Set<String> neverHeard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            neverHeard.add(sc.next());
        }
        Set<String> neverSeen = new HashSet<>();
        for (int i = 0; i < m; i++) {
            neverSeen.add(sc.next());
        }

        neverHeard.retainAll(neverSeen);

        List<String> neverHeardNeverSeen = new ArrayList<>(neverHeard);
        Collections.sort(neverHeardNeverSeen);

        System.out.println(neverHeardNeverSeen.size());
        for (String s : neverHeardNeverSeen) {
            System.out.println(s);
        }
    }
}