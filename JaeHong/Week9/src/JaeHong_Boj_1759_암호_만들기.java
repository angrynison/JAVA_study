import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class JaeHong_Boj_1759_암호_만들기 {
    static char[] chars;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        chars = new char[c];
        for (int i = 0; i < c; i++) {
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars);
        char[] cur = new char[l];
        makePassword(l, 0, 0, cur);
    }

    private static void makePassword(int l, int idx, int len, char[] cur) {
        // 종료 조건 : l 길이가 되면 암호에 저장
        // 최소 1개의 모음과 최소 2개의 자음이 있어야 함
        // 구성하는 알파벳은 사전순 으로 정렬돼야 함x
        if (len == l) {
            int vowelCount = 0;
            int consonantCount = 0;
            for (char c : cur) {
                // indexOf를 사용하여 모음인지 자음인지 확인
                if ("aeiou".indexOf(c) != -1) { // == "aeiou 인에 c라는 글자가 있으면
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            // 최소 1개의 모음과 최소 2개의 자음이 있어야 함
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(new String(cur)); // 현재 조합을 문자열로 변환하여 출력
            }
            return; // 종료 조건 만족 시 함수 종료
        }

        //재귀 조건
        for (int i = idx; i < chars.length; i++) {
            cur[len] = chars[i]; // 현재 위치에 문자 할당
            makePassword(l, i + 1, len + 1, cur); // 다음 문자 선택
        }
    }
}
