import java.io.*;
import java.util.*;

public class janghyuk_boj_1759 {
    static int L, C;
    static char[] letters;
    static char[] password;
    static StringBuilder sb = new StringBuilder();
    static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // 모음확인 집합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C]; // 입력알파벳
        password = new char[L]; // 암호 조합ㅇ,ㄹ 담는 변수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters); // 사전순 암호를 만들기 위해 정렬
        dfs(0, 0); // 시작 인덱스와 깊이

        System.out.print(sb);
    }

    static void dfs(int start, int depth) { // 다음 재귀때 고를 알파벳의 위치를 넘겨줌
        if (depth == L) {
            if (isValid(password)) { //모음 1개 이상, 자음 2개 이상 조건 체크
                sb.append(new String(password)).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) { // 모든 알파벳 조합을 하나씩 선택
            password[depth] = letters[i];
            dfs(i + 1, depth + 1); // 다음 문자 선택
        }
    }

    static boolean isValid(char[] pw) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : pw) {
            if (vowels.contains(c)) vowelCount++;
            else consonantCount++;
        }

        return vowelCount >= 1 && consonantCount >= 2; // 1개의 모음 자음 2개 포함하는지
    }
}
