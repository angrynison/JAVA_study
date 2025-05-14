// 문제 : 백준1296
// 태그 : 정렬

// 연두의 이름과 팀 이름을 붙여서, 연두의 이름 문자별 개수를 센다.
// 개수들로 공식에 넣는다. L, O, V, E 로 고정
// mode 100이 가장 큰 팀을 고른다.

import java.util.Arrays;
import java.util.Scanner;

public class Sort_1296 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int N = Integer.parseInt(scanner.nextLine());


        String[] teams = new String[N];
        for(int i=0; i<N; i++){
            teams[i] = scanner.nextLine();
        }
        Arrays.sort(teams); // 같은 확률이면 사전순 정렬


        int bestScore = -1;
        String bestTeam = "";
        for(String team : teams){
            String combined = name + team;
            int L = 0, O = 0, V= 0, E=0;
            for(int i=0; i<combined.length(); i++){
                char c = combined.charAt(i);
                if(c=='L'){
                    L++;
                } else if (c=='O') {
                    O++;
                } else if (c=='V') {
                    V++;
                } else if (c=='E') {
                    E++;
                }
            }
            int score = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100; // 나머지
            if(score > bestScore){
                bestScore = score;
                bestTeam = team;
            } else if (score == bestScore && team.compareTo(bestTeam)<0) {
                // 사전순으로 정렬
                bestTeam = team;
            }
        }
        System.out.println(bestTeam);


    }
}
