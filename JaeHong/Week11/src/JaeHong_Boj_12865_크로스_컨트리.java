import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class TeamResult implements Comparable<TeamResult> {
    int totalScore;
    int fifthScore;
    int teamId;

    public TeamResult(int totalScore, int fifthScore, int teamId) {
        this.totalScore = totalScore;
        this.fifthScore = fifthScore;
        this.teamId = teamId;
    }

    /**
     * 정렬 규칙을 정의하는 메소드.
     * 1. 총점을 기준으로 오름차순 정렬.
     * 2. 총점이 같으면 5번째 주자의 점수를 기준으로 오름차순 정렬.
     */
    @Override
    public int compareTo(TeamResult other) {
        // 총점이 다르면 총점을 기준으로 비교
        if (this.totalScore != other.totalScore) {
            return Integer.compare(this.totalScore, other.totalScore);
        }
        // 총점이 같으면 5번째 주자의 점수를 기준으로 비교
        return Integer.compare(this.fifthScore, other.fifthScore);
    }
}

public class JaeHong_Boj_12865_크로스_컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 주자의 수
            int[] finishOrder = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                finishOrder[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solve(finishOrder)); // 최종 결과 한 번에 출력
        }
    }

    public static int solve(int[] finishOrder) {
        // 1. 각 팀의 주자 수를 계산합니다.
        Map<Integer, Integer> teamCounts = new HashMap<>();
        for (int team : finishOrder) {
            teamCounts.put(team, teamCounts.getOrDefault(team, 0) + 1);
        }

        // 2. 참가 자격이 있는 팀(6명)을 선별합니다.
        Set<Integer> eligibleTeams = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : teamCounts.entrySet()) {
            if (entry.getValue() == 6) {
                eligibleTeams.add(entry.getKey());
            }
        }

        // 3. 자격 있는 팀의 주자들에게만 순서대로 점수를 부여합니다.
        Map<Integer, List<Integer>> scoresByTeam = new HashMap<>();
        int scorePoint = 1;
        for (int team : finishOrder) {
            if (eligibleTeams.contains(team)) {
                // computeIfAbsent: 키가 없으면 새 ArrayList를 생성하고, 있으면 기존 리스트를 반환
                scoresByTeam.computeIfAbsent(team, k -> new ArrayList<>()).add(scorePoint);
                scorePoint++;
            }
        }

        // 4. 각 팀의 최종 점수를 계산하여 리스트에 담습니다.
        List<TeamResult> results = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : scoresByTeam.entrySet()) {
            int teamId = entry.getKey();
            List<Integer> scores = entry.getValue();

            int totalScore = 0;
            for (int i = 0; i < 4; i++) { // 상위 4명의 점수 합산
                totalScore += scores.get(i);
            }
            int fifthRunnerScore = scores.get(4); // 5번째 주자 점수

            results.add(new TeamResult(totalScore, fifthRunnerScore, teamId));
        }

        // 5. 결과를 정렬합니다.
        Collections.sort(results);

        // 정렬 후 첫 번째 팀이 우승팀입니다.
        return results.get(0).teamId;
    }
}