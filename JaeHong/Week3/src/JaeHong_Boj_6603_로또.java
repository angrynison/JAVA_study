import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class JaeHong_Boj_6603_로또 {
    static int k;
    static int[] s;
    static List<List<Integer>> results;

    public static void combination(List<Integer> currentCombination, int startIndex) {
        if (currentCombination.size() == 6) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < k; i++) {
            currentCombination.add(s[i]);
            combination(currentCombination, i + 1);
            currentCombination.remove(currentCombination.size() - 1); // 백트래킹
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            results = new ArrayList<>();
            combination(new ArrayList<>(), 0);

            for (List<Integer> result : results) {
                System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
            System.out.println(); // 각 테스트 케이스 사이 빈 줄 출력
        }
    }
}