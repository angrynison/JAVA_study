// 파일은 문제명 유지
// 내부클래스는 class solution
import java.util.*;

class PhoneBookSolution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        // 모든 전화번호를 set에 저장
        for (String number : phone_book) {
            set.add(number);
        }

        // 각 번호에 대해 접두사 검사
        for (String number : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length() - 1; i++) {
                sb.append(number.charAt(i));
                if (set.contains(sb.toString())) {
                    return false;  // 접두사 있음
                }
            }
        }

        return true;  // 접두사 없음
    }
}

//public class JiHyeon_programmers_전화번호목록 {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        System.out.println(result);
//    }
//}