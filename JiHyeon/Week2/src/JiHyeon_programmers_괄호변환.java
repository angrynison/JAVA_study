import java.util.*;
class Solution {
    public String solution(String p) {

        // () 의 개수가 같으면 => 균형잡힌 괄호 문자열
        // () 의 개수와 짝, 순서 맞으면 => 올바른 괄호 문자열
        // w -> u와 v로 나눈다.
        // u가 올바른 문자열

        if(isCorrect(p)){
            return p; // 이미 올바른 괄호 문자열인 경우
        }
        return selfFunction(p);



    }
    public String selfFunction(String p){


//      1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.equals("")){
            return "";
        }

//      2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//      u는 여는 괄호의 개수와 닫는 괄호의 개수가 같도록 분리
        int index = seperateIndex(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

//      3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(isCorrect(u)){
//       3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + selfFunction(v);
        }
//      4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else {
//       4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            String answer = "(";
//       4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            answer += selfFunction(v);
//       4-3. ')'를 다시 붙입니다.
            answer += ")";
//       4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            String temp = u.substring(1, u.length()-1);
            StringBuilder sb = new StringBuilder();
            for(char c : temp.toCharArray()){
                if(c=='('){
                    sb.append(')');
                }else {
                    sb.append('(');
                }
            }
            answer+= sb.toString();
//       4-5. 생성된 문자열을 반환합니다.
            return answer;
        }

    }

    public int seperateIndex(String w){
        int open = 0;
        int close = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i)=='('){
                open++;
            }else {
                close++;
            }

            if(open==close){
                return i;
            }
        }
        return -1; // 비정상 입력
    }

    public boolean isCorrect(String str) { // 올바른 괄호 문자열인지 확인 함수
        if(str.equals("")){
            return true; // 빈 문자열 == 올바른 괄호 문자열
        }
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();

            }
        }
        return stack.isEmpty(); // 비어있으면 올바른
    }
}



public class JiHyeon_programmers_괄호변환 {
}
